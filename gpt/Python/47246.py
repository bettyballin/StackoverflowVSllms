import os\n\n# Variables\na = "folderA"\nb = "folderB"\nc = "folderC"\nd = "fileD"\n\n# Concatenate the file path\nfile_path = os.path.join("C:\\", a, b, c, d + ".txt")\n\n# Create directories if they don't exist\nos.makedirs(os.path.dirname(file_path), exist_ok=True)\n\n# Now you can save the file\nwith open(file_path, 'w') as file:\n    file.write("Your content here")