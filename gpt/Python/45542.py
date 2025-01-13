import os\nfrom collections import defaultdict\nimport re\n\ndef group_files(directory):\n    file_groups = defaultdict(int)\n    pattern = re.compile(r'(\D+)\d*')\n\n    for filename in os.listdir(directory):\n        match = pattern.match(filename)\n        if match:\n            group_name = match.group(1).strip()\n            file_groups[group_name] += 1\n\n    for group, count in file_groups.items():\n        print(f"{group} ( {count} pictures )")\n\n# Example usage\ndirectory = 'path_to_your_directory'\ngroup_files(directory)