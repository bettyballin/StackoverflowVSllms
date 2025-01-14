import glob\n\n# Define the directory path (use '.' for current directory)\ndirectory_path = '/path/to/directory'\n\n# Use glob to find all files matching the pattern *tmp*.log\nmatching_files = glob.glob(f'{directory_path}/*tmp*.log')\n\n# Print the list of matched files\nfor file in matching_files:\n    print(file)