import hashlib\n\ndef generate_signature(mac_address, device_details, secret_key):\n    # Concatenate MAC address and device details\n    data = mac_address + device_details\n    \n    # Add a secret key to make it more difficult to reverse-engineer\n    data += secret_key\n    \n    # Use SHA-256 to generate a 256-bit hash\n    hash_object = hashlib.sha256(data)\n    \n    # Truncate the hash to 64 bits (8 bytes)\n    signature = hash_object.digest()[:8]\n    \n    return signature\n\n# Example usage:\nmac_address = b'\x00\x11\x22\x33\x44\x55'\ndevice_details = b'some_device_details'\nsecret_key = b'my_secret_key'\n\nsignature = generate_signature(mac_address, device_details, secret_key)\nprint(signature.hex())