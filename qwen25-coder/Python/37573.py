import mmap\nimport json\n\ndef write_to_mmap(data, file_path):\n    data_json = json.dumps(data)\n    with open(file_path, 'wb') as f:\n        # Ensure the file size is enough to hold the data + length prefix\n        length_prefix = len(data_json).to_bytes(4, byteorder='big')\n        f.write(length_prefix + data_json.encode('utf-8'))\n    \n    return mmap.mmap(f.fileno(), 0)\n\ndata = {"key": "value", "numbers": [1, 2, 3]}\nmm = write_to_mmap(data, 'shared_memory.bin')