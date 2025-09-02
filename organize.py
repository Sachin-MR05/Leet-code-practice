import os
import json
import shutil
import re

# Load problem mapping
with open("problem_tags.json", "r") as f:
    problem_tags = json.load(f)

base_dir = os.getcwd()

# Create category folders if they don't exist
categories = set(problem_tags.values()) | {"others"}
for cat in categories:
    os.makedirs(os.path.join(base_dir, cat), exist_ok=True)

# First, check if we need to process folders in "others/" directory
others_dir = os.path.join(base_dir, "others")
if os.path.exists(others_dir):
    # Process folders in others directory
    for item in os.listdir(others_dir):
        item_path = os.path.join(others_dir, item)
        
        # Skip non-problem folders/files
        if not os.path.isdir(item_path):
            continue
        
        # Extract problem name from format like "0048-rotate-image"
        # Remove leading numbers and hyphens, convert to title case
        if re.match(r'^\d+-', item):
            # Remove leading numbers and hyphen
            problem_name = re.sub(r'^\d+-', '', item)
            # Convert hyphens to spaces and title case
            problem_name = problem_name.replace('-', ' ').title()
        else:
            problem_name = item

        # Find target category from mapping
        category = problem_tags.get(problem_name, "others")

        # Target path
        target_path = os.path.join(base_dir, category, item)

        # Move folder if not already there
        if not os.path.exists(target_path):
            shutil.move(item_path, target_path)
            print(f"Moved '{item}' from others/ to '{category}/' (matched: '{problem_name}')")
        else:
            print(f"'{item}' already in correct category '{category}/'")

# Also scan through all items in base directory (for new problems)
for item in os.listdir(base_dir):
    item_path = os.path.join(base_dir, item)

    # Skip non-problem folders/files and already processed directories
    if not os.path.isdir(item_path):
        continue
    if item in categories or item.startswith(".github") or item == ".git" or item == "others":
        continue

    # Extract problem name from format like "0048-rotate-image"
    # Remove leading numbers and hyphens, convert to title case
    if re.match(r'^\d+-', item):
        # Remove leading numbers and hyphen
        problem_name = re.sub(r'^\d+-', '', item)
        # Convert hyphens to spaces and title case
        problem_name = problem_name.replace('-', ' ').title()
    else:
        problem_name = item

    # Find target category from mapping
    category = problem_tags.get(problem_name, "others")

    # Target path
    target_path = os.path.join(base_dir, category, item)

    # Move folder if not already there
    if not os.path.exists(target_path):
        shutil.move(item_path, target_path)
        print(f"Moved '{item}' to '{category}/' (matched: '{problem_name}')")
    else:
        print(f"'{item}' already in correct category '{category}/'")

# After organizing, run generate_stats.py to update statistics

