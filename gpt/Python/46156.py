import os\nimport hashlib\n\n# Function to calculate the SHA-256 hash of a file\ndef sha256(file_path):\n    hasher = hashlib.sha256()\n    with open(file_path, 'rb') as f:\n        for chunk in iter(lambda: f.read(4096), b""):\n            hasher.update(chunk)\n    return hasher.hexdigest()\n\n# Directory containing the files\ndirectory = '/path/to/files'\n\n# Calculate the hash for each file in the directory\nfile_hashes = {}\nfor filename in os.listdir(directory):\n    file_path = os.path.join(directory, filename)\n    if os.path.isfile(file_path):\n        file_hash = sha256(file_path)\n        if file_hash in file_hashes:\n            file_hashes[file_hash].append(filename)\n        else:\n            file_hashes[file_hash] = [filename]\n\n# Check if all files are identical\nall_files_identical = len(file_hashes) == 1\nif all_files_identical:\n    print("All files are identical.")\nelse:\n    print("Files are not identical.")\n    for file_hash, files in file_hashes.items():\n        print(f"Hash: {file_hash} -> Files: {files}")