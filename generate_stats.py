#!/usr/bin/env python3
"""
Generate statistics for LeetCode practice repository
Counts folders, files, and creates visualizations
"""

import os
import json
import re
import subprocess
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
from datetime import datetime
import glob

def get_git_log_for_file(filepath):
    """Get git log for a specific file to extract runtime and space info"""
    try:
        result = subprocess.run([
            'git', 'log', '--follow', '--pretty=format:%s', '--', filepath
        ], capture_output=True, text=True, cwd='.')
        
        if result.returncode == 0:
            return result.stdout.split('\n')
        return []
    except:
        return []

def parse_commit_message(message):
    """Parse commit message for runtime and space information"""
    runtime = None
    space = None
    
    # Look for patterns like "Runtime: 100ms" or "Time: 1.5s"
    time_match = re.search(r'(?:runtime|time)[:\s]+([\d.]+)\s*(ms|s)', message.lower())
    if time_match:
        value = float(time_match.group(1))
        unit = time_match.group(2)
        if unit == 'ms':
            runtime = value / 1000  # Convert to seconds
        else:
            runtime = value
    
    # Look for patterns like "Space: 10MB" or "Memory: 50.5MB"
    space_match = re.search(r'(?:space|memory)[:\s]+([\d.]+)\s*(MB|KB|GB)', message.lower())
    if space_match:
        value = float(space_match.group(1))
        unit = space_match.group(2)
        if unit == 'KB':
            space = value / 1024  # Convert to MB
        elif unit == 'GB':
            space = value * 1024  # Convert to MB
        else:
            space = value
    
    return runtime, space

def get_folder_stats():
    """Get statistics for all folders including 'others'"""
    stats = []

    # Define category folders (excluding 'others')
    category_folders = ['numpy', 'pandas', 'sklearn', 'Python basics']

    for category in sorted(category_folders):
        category_path = os.path.join('.', category)

        # Category path is already set correctly

        if os.path.exists(category_path):
            # Find all problem folders within this category
            for item in os.listdir(category_path):
                problem_path = os.path.join(category_path, item)
                if os.path.isdir(problem_path):
                    # Find Python files in this problem folder
                    python_files = []
                    for root, dirs, files in os.walk(problem_path):
                        for file in files:
                            if file.endswith('.py'):
                                python_files.append(os.path.join(root, file))

                    # Get stats for each problem file
                    for file_path in python_files:
                        # Extract problem name from folder name (not file name)
                        problem_name = item

                        # Get git log and parse for runtime/space
                        commit_messages = get_git_log_for_file(file_path)
                        runtime, space = None, None

                        for msg in commit_messages:
                            rt, sp = parse_commit_message(msg)
                            if rt is not None:
                                runtime = rt
                            if sp is not None:
                                space = sp
                            if runtime is not None and space is not None:
                                break

                        stats.append({
                            'folder': category,
                            'problem': problem_name,
                            'file_path': file_path,
                            'runtime': runtime,
                            'space': space
                        })

    return stats

def generate_bar_chart(stats, output_path):
    """Generate bar chart showing problems per category"""
    df = pd.DataFrame(stats)
    category_counts = df['folder'].value_counts()
    
    plt.figure(figsize=(10, 6))
    category_counts.plot(kind='bar', color='skyblue')
    plt.title('LeetCode Problems by Category')
    plt.xlabel('Category')
    plt.ylabel('Number of Problems')
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.savefig(output_path, dpi=100, bbox_inches='tight')
    plt.close()

def generate_ring_chart(stats, output_path):
    """Generate ring chart showing average runtime and space"""
    df = pd.DataFrame(stats)
    
    # Calculate averages (excluding None values)
    avg_runtime = df['runtime'].dropna().mean() if not df['runtime'].dropna().empty else 0
    avg_space = df['space'].dropna().mean() if not df['space'].dropna().empty else 0
    
    # Create ring chart
    fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(12, 5))
    
    # Runtime ring chart
    if avg_runtime > 0:
        ax1.pie([avg_runtime, max(0, 10 - avg_runtime)], 
                labels=[f'{avg_runtime:.1f}s', ''], 
                colors=['lightcoral', 'lightgray'],
                startangle=90)
        ax1.set_title('Average Runtime (seconds)')
    else:
        ax1.text(0.5, 0.5, 'No runtime data', ha='center', va='center')
        ax1.set_title('Average Runtime')
    
    # Space ring chart
    if avg_space > 0:
        ax2.pie([avg_space, max(0, 100 - avg_space)], 
                labels=[f'{avg_space:.1f}MB', ''], 
                colors=['lightgreen', 'lightgray'],
                startangle=90)
        ax2.set_title('Average Space (MB)')
    else:
        ax2.text(0.5, 0.5, 'No space data', ha='center', va='center')
        ax2.set_title('Average Space')
    
    plt.tight_layout()
    plt.savefig(output_path, dpi=100, bbox_inches='tight')
    plt.close()

def update_readme(stats):
    """Update README.md with statistics"""
    # Create stats directory if it doesn't exist
    os.makedirs('stats', exist_ok=True)

    # Generate charts
    generate_bar_chart(stats, 'stats/problems_by_category.png')
    generate_ring_chart(stats, 'stats/average_stats.png')

    # Read current README
    with open('README.md', 'r', encoding='utf-8') as f:
        content = f.read()

    # Remove old statistics section if it exists
    stats_pattern = r'## 📊 LeetCode Practice Statistics.*?(?=## |\Z)'
    content = re.sub(stats_pattern, '', content, flags=re.DOTALL)

    # Remove any duplicate statistics sections
    content = re.sub(r'## 📋 Problems Summary.*?(?=## |\Z)', '', content, flags=re.DOTALL)

    # Clean up any extra blank lines
    content = re.sub(r'\n\n\n+', '\n\n', content)

    # Group stats by folder
    folder_groups = {}
    for stat in stats:
        folder = stat['folder']
        if folder not in folder_groups:
            folder_groups[folder] = []
        folder_groups[folder].append(stat)

    # Create statistics section
    stats_section = f"""## 📊 LeetCode Practice Statistics

*Last updated: {datetime.now().strftime("%Y-%m-%d %H:%M:%S")}*

### 📋 Problems Summary

| Category | Problem | Runtime (s) | Space (MB) |
|----------|---------|-------------|------------|
"""

    # Add table rows with grouped categories
    for folder, problems in folder_groups.items():
        # Add category header row
        folder_link = f"[{folder}]({folder})"
        stats_section += f"| **{folder_link}** | | | |\n"

        # Add problems as sub-rows
        for stat in problems:
            problem_link = f"[{stat['problem']}]({stat['file_path']})"
            runtime = f"{stat['runtime']:.2f}" if stat['runtime'] is not None else "N/A"
            space = f"{stat['space']:.1f}" if stat['space'] is not None else "N/A"

            stats_section += f"| | {problem_link} | {runtime} | {space} |\n"

    # Add charts
    stats_section += f"""

### 📈 Activity Overview

<img src="stats/problems_by_category.png" alt="Problems by Category" width="600">

### 🎯 Performance Metrics

<img src="stats/average_stats.png" alt="Average Statistics" width="600">

---
*Statistics generated automatically by GitHub Actions*
"""

    # Insert stats section after ML/DL section
    if "## ⚡ Why ML/DL + LeetCode?" in content:
        # Split content and insert stats after ML/DL section
        parts = content.split("## ⚡ Why ML/DL + LeetCode?", 1)
        if len(parts) > 1:
            ml_dl_content = parts[1]
            # Find the end of this section (next header or end of file)
            next_header_match = re.search(r'\n## ', ml_dl_content)
            if next_header_match:
                insert_pos = next_header_match.start()
                new_content = parts[0] + "## ⚡ Why ML/DL + LeetCode?" + ml_dl_content[:insert_pos] + "\n\n" + stats_section + ml_dl_content[insert_pos:]
            else:
                new_content = parts[0] + "## ⚡ Why ML/DL + LeetCode?" + ml_dl_content + "\n\n" + stats_section
        else:
            new_content = content + "\n\n" + stats_section
    else:
        # Add ML/DL section if it doesn't exist
        content += "\n\n## ⚡ Why ML/DL + LeetCode?\n\n"
        new_content = content + stats_section

    # Write updated content
    with open('README.md', 'w', encoding='utf-8') as f:
        f.write(new_content)

def main():
    """Main function"""
    print("Generating LeetCode statistics...")
    stats = get_folder_stats()
    print(f"Found {len(stats)} problems")
    update_readme(stats)
    print("README.md updated successfully!")

if __name__ == "__main__":
    main()
