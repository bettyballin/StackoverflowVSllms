import os\n\ndef seal(number):\n    # Generate a random initialization vector\n    iv = os.urandom(8)\n    \n    # Convert number to bytes (assuming bid is less than 1 million)\n    num_bytes = float_to_bytes(number)\n    \n    # XOR each byte of the number with the byte from IV\n    sealed_number = bytes([a ^ b for a, b in zip(num_bytes * 2, iv)])\n    \n    # Combine IV and sealed number to form the 'sealed' output\n    result = iv + sealed_number\n    \n    return result.hex()  # Return as hex string\n\ndef unseal(sealed_hex):\n    # Convert hex string back to bytes\n    data = bytes.fromhex(sealed_hex)\n    \n    # Separate IV and sealed number\n    iv, sealed_number = data[:8], data[8:]\n    \n    # Reverse the XOR process to get original number bytes\n    num_bytes = bytes([a ^ b for a, b in zip(sealed_number, iv)])\n    \n    return bytes_to_float(num_bytes)\n\ndef float_to_bytes(f):\n    # Convert float to 8-byte representation\n    import struct\n    return struct.pack('!d', f)\n\ndef bytes_to_float(b):\n    # Convert 8-byte representation back to float\n    import struct\n    return struct.unpack('!d', b)[0]\n\n# Example usage:\nsealed = seal(7)\nprint("Sealed:", sealed)\nunsealed = unseal(sealed)\nprint("Unsealed:", unsealed)