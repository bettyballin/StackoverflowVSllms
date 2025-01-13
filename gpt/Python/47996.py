import os\nimport shutil\n\ndef copy_files_with_extension(src_dir, dest_dir, extension):\n    if not os.path.exists(dest_dir):\n        os.makedirs(dest_dir)\n\n    for root, dirs, files in os.walk(src_dir):\n        # Skip subdirectories\n        if root != src_dir:\n            continue\n\n        for file in files:\n            if file.endswith(extension):\n                src_file = os.path.join(root, file)\n                dest_file = os.path.join(dest_dir, file)\n                shutil.copy2(src_file, dest_file)\n                print(f"Copied {src_file} to {dest_file}")\n\n# Example usage\nsource_directory = '/path/to/source/folder'\ndestination_directory = '/path/to/destination/folder'\nfile_extension = '.txt'  # Replace with your specific file extension\n\ncopy_files_with_extension(source_directory, destination_directory, file_extension)