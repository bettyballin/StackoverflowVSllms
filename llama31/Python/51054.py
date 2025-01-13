import hashlib\nimport os\n\ndef calculate_block_size(file_size):\n    # Dynamically calculate block size based on file size\n    if file_size < 1024 * 1024:  # 1MB\n        return 1024  # 1KB\n    elif file_size < 1024 * 1024 * 1024:  # 1GB\n        return 1024 * 1024  # 1MB\n    else:\n        return 1024 * 1024 * 1024  # 1GB\n\ndef calculate_block_hash(block_data):\n    # Calculate SHA-256 hash of the block data\n    return hashlib.sha256(block_data).hexdigest()\n\ndef deduplicate_data(file_data, block_size):\n    blocks = []\n    for i in range(0, len(file_data), block_size):\n        block_data = file_data[i:i+block_size]\n        block_hash = calculate_block_hash(block_data)\n        blocks.append((block_hash, block_data))\n    return blocks\n\ndef transfer_data(blocks, ftp_connection):\n    # Transfer only the changed blocks\n    for block_hash, block_data in blocks:\n        if block_hash not in ftp_connection.get_existing_blocks():\n            ftp_connection.transfer_block(block_data)