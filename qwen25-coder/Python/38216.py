import os\n\ndef organize_files(path, max_files_per_dir=1000):\n    """\n    Organize files in a directory into subdirectories with a maximum number of files per subdirectory.\n    """\n    # Get all files in the target directory\n    files = [f for f in os.listdir(path) if os.path.isfile(os.path.join(path, f))]\n    \n    # Sort files to maintain order\n    files.sort()\n    \n    # Create subdirectories as needed and move files\n    subdir_count = 0\n    for i in range(0, len(files), max_files_per_dir):\n        subdir_path = os.path.join(path, f"subdir_{subdir_count:03}")\n        os.makedirs(subdir_path, exist_ok=True)\n        \n        # Move files into the current subdirectory\n        for file in files[i:i + max_files_per_dir]:\n            src_file_path = os.path.join(path, file)\n            dest_file_path = os.path.join(subdir_path, file)\n            os.rename(src_file_path, dest_file_path)\n        \n        subdir_count += 1\n\n# Example usage\norganize_files("path/to/your/directory")