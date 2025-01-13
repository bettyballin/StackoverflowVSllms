import hashlib\nimport os\n\ndef hash_chunks(file_path, chunk_size=4096):\n    """Generate SHA-256 hashes for each chunk of the file."""\n    hashes = []\n    with open(file_path, 'rb') as f:\n        while chunk := f.read(chunk_size):\n            chunk_hash = hashlib.sha256(chunk).hexdigest()\n            hashes.append(chunk_hash)\n    return hashes\n\ndef hamming_distance(hash1, hash2):\n    """Calculate the hamming distance between two hex hashes."""\n    assert len(hash1) == len(hash2)\n    return sum(c1 != c2 for c1, c2 in zip(hash1, hash2))\n\ndef calculate_similarity(file1, file2, chunk_size=4096):\n    """Calculate similarity percentage between two files."""\n    hashes1 = hash_chunks(file1, chunk_size)\n    hashes2 = hash_chunks(file2, chunk_size)\n    \n    # Ensure both files are represented by the same number of chunks\n    min_length = min(len(hashes1), len(hashes2))\n    hashes1, hashes2 = hashes1[:min_length], hashes2[:min_length]\n    \n    total_distance = sum(hamming_distance(h1, h2) for h1, h2 in zip(hashes1, hashes2))\n    max_distance = len(hashes1[0]) * 4 * len(hashes1)  # Each hex digit represents 4 bits\n\n    similarity_percentage = 100 * (1 - total_distance / max_distance)\n    return similarity_percentage\n\n# Example usage:\nfile1 = 'path/to/rom1.bin'\nfile2 = 'path/to/rom2.bin'\nsimilarity = calculate_similarity(file1, file2)\nprint(f'Similarity: {similarity:.2f}%')