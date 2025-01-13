def pkcs7_pad(data, block_size=4):\n    padding_len = block_size - (len(data) % block_size)\n    padding = bytes([padding_len] * padding_len)\n    return data + padding\n\ndef pkcs7_unpad(padded_data, block_size=4):\n    padding_len = padded_data[-1]\n    if padding_len < 1 or padding_len > block_size:\n        raise ValueError("Invalid padding length")\n    return padded_data[:-padding_len]\n\n# Example usage:\ndata = b"Hello, World!"\npadded_data = pkcs7_pad(data)\nprint("Padded data:", padded_data)\n\nunpadded_data = pkcs7_unpad(padded_data)\nprint("Unpadded data:", unpadded_data)