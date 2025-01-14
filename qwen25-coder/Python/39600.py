import os\nimport json\n\ndef hash_file_contents(file_path):\n    import hashlib\n    """Generate an MD5 hash for the file content."""\n    hasher = hashlib.md5()\n    with open(file_path, 'rb') as afile:\n        buf = afile.read(65536)  # Read in chunks to save memory on big files.\n        while len(buf) > 0:\n            hasher.update(buf)\n            buf = afile.read(65536)\n    return hasher.hexdigest()\n\ndef get_metadata(directory):\n    """Recursively gather metadata about all files in the directory."""\n    metadata = {}\n    for root, dirs, files in os.walk(directory):\n        for file in files:\n            file_path = os.path.join(root, file)\n            stats = os.stat(file_path)\n            metadata[file_path] = {\n                'timestamp': stats.st_mtime,\n                'size': stats.st_size\n                # Uncomment the following line to use hashes if needed.\n                # 'hash': hash_file_contents(file_path)\n            }\n    return metadata\n\ndef find_changed_files(metadata_old, metadata_new):\n    """Find files changed between two sets of metadata."""\n    changes = {}\n    all_files = set(metadata_old.keys()).union(set(metadata_new.keys()))\n    for file_path in all_files:\n        if file_path not in metadata_old or file_path not in metadata_new:\n            # New file or deleted file\n            changes[file_path] = 'changed'\n        elif (metadata_old[file_path]['size'] != metadata_new[file_path]['size'] or\n              metadata_old[file_path]['timestamp'] != metadata_new[file_path]['timestamp']):\n            # File has changed size or modification time.\n            changes[file_path] = 'changed'\n        # Uncomment the following block if using hash values.\n        # elif metadata_old[file_path]['hash'] != metadata_new[file_path]['hash']:\n        #     # Content of file is different\n        #     changes[file_path] = 'changed'\n    return changes\n\n# Usage example:\ncurrent_metadata = get_metadata('/path/to/your/folder')\nold_metadata_file = '/path/to/metadata.json'\n\ntry:\n    with open(old_metadata_file, 'r') as f:\n        old_metadata = json.load(f)\nexcept FileNotFoundError:\n    # If the metadata file doesn't exist, consider all files new.\n    changes_detected = {f: 'changed' for f in current_metadata.keys()}\nelse:\n    changes_detected = find_changed_files(old_metadata, current_metadata)\n\n# Save the current metadata to reuse it next time\nwith open(old_metadata_file, 'w') as f:\n    json.dump(current_metadata, f)