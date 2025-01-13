import re\n\ndef make_valid_filename(s):\n    # Define a regex pattern to match unwanted characters\n    pattern = r'[^a-zA-Z0-9_\-.\(\) ]+'\n    # Substitute unwanted characters with an empty string\n    return re.sub(pattern, '', s)\n\n# Example usage\nfilename = "Invalid|Filename:With*Special<Characters>?/\\"\nvalid_filename = make_valid_filename(filename)\nprint(valid_filename)  # Output: InvalidFilenameWithSpecialCharacters