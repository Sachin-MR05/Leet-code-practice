import os
import json
import shutil

# Load problem mapping
with open("problem_tags.json", "r") as f:
    problem_tags = json.load(f)

base_dir = os.getcwd()

# Create category folders if they don't exist
categories = set(problem_tags.values()) | {"others"}
for cat in categories:
    os.makedirs(os.path.join(base_dir, cat), exist_ok=True)

# Scan through all items in repo
for item in os.listdir(base_dir):
    item_path = os.path.join(base_dir, item)

    # Skip non-problem folders/files
    if not os.path.isdir(item_path):
        continue
    if item in categories or item.startswith(".github"):
        continue

    # Extract problem name (remove number prefix like '48. ')
    if ". " in item:
        problem_name = item.split(". ", 1)[1]
    else:
        problem_name = item

    # Find target category from mapping
    category = problem_tags.get(problem_name, "others")

    # Target path
    target_path = os.path.join(base_dir, category, item)

    # Move folder if not already there
    if not os.path.exists(target_path):
        shutil.move(item_path, target_path)
