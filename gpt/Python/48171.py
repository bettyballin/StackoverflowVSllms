import glob\nimport os\n\n# Specify the directory you want to search in\ndirectory = '/path/to/your/directory'\n\n# Use glob to find files that match the pattern *tmp*.log\npattern = os.path.join(directory, '*tmp*.log')\nmatching_files = glob.glob(pattern)\n\n# Print the list of matching files\nfor file in matching_files:\n    print(file)