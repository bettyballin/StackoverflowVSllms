import os\nimport shutil\nimport re\n\ndef read_file_list(file_path):\n    directory_dict = {}\n    current_directory = None\n    \n    with open(file_path, 'r') as file:\n        for line in file:\n            line = line.strip()\n            if line.startswith('Directory:'):\n                # Extract the directory name and strip any trailing slashes\n                current_directory = re.search(r'Directory:\s*(.+)', line).group(1).rstrip('\\/')\n                directory_dict[current_directory] = []\n            elif line.startswith('->'):\n                file_name = line.split('-> ')[1]\n                if current_directory:  # Ensure we're in a valid directory context\n                    directory_dict[current_directory].append(file_name)\n                    \n    return directory_dict\n\ndef organize_files(directory_dict, source_dir):\n    for category, files in directory_dict.items():\n        category_path = os.path.join(source_dir, category)\n        if not os.path.exists(category_path):\n            os.makedirs(category_path)  # Create the directory if it doesn't exist\n        \n        for file_name in files:\n            src_file = os.path.join(source_dir, file_name)\n            dest_file = os.path.join(category_path, file_name)\n            \n            if os.path.exists(src_file):\n                shutil.copy2(src_file, dest_file)  # Use move() instead of copy2 to move files\n                print(f'Moved {file_name} to {category}')\n            else:\n                print(f'File not found: {file_name}')\n\n# Example usage:\nfile_list_path = 'path_to_your_file_list.txt'\nsource_directory = 'path_to_your_source_directory'\n\ndirectory_mapping = read_file_list(file_list_path)\norganize_files(directory_mapping, source_directory)