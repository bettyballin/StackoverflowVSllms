import os\nimport hashlib\n\ndef calculate_file_hash(file_path):\n    with open(file_path, 'rb') as f:\n        file_hash = hashlib.sha256(f.read()).hexdigest()\n    return file_hash\n\ndef find_duplicate_files(directory):\n    file_hashes = {}\n    for root, dirs, files in os.walk(directory):\n        for file in files:\n            file_path = os.path.join(root, file)\n            file_hash = calculate_file_hash(file_path)\n            if file_hash in file_hashes:\n                print(f"Duplicate file found: {file_path} (matches {file_hashes[file_hash]})")\n            else:\n                file_hashes[file_hash] = file_path\n\nfind_duplicate_files('/path/to/directory')