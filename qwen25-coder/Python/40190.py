import os\n\n# Path to the directory you want to inspect\npath = '/your/directory/path'\n\nfor dirpath, dirnames, filenames in os.walk(path):\n    # Process directories and files as needed\n    print(f'Current Directory: {dirpath}')\n    print(f'Directories: {dirnames}')\n    print(f'Files: {filenames}')\n    \n    # Add a file to each directory\n    for dirname in dirnames:\n        with open(os.path.join(dirpath, dirname, 'new_file.txt'), 'w') as f:\n            f.write('This is another test file.')