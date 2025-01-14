import zlib\n\ndef compress_data(data):\n    return zlib.compress(data)\n\ndef decompress_data(compressed_data):\n    return zlib.decompress(compressed_data)\n\n# Example usage\noriginal_data = b'This is some data that we want to compress.'\ncompressed = compress_data(original_data)\ndecompressed = decompress_data(compressed)\n\nprint("Original:", original_data)\nprint("Compressed:", compressed)\nprint("Decompressed:", decompressed)