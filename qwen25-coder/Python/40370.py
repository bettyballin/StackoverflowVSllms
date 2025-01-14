import uuid\nimport hashlib\n\ndef generate_registration_code():\n    # Get unique machine identifier\n    mac = hex(uuid.getnode()).replace('0x', '').upper()\n    # Optionally, combine with other unique identifiers like CPU or HDD serial numbers\n    \n    # Use a strong hashing algorithm to create the registration code\n    hash_object = hashlib.sha256(mac.encode())\n    registration_code = hash_object.hexdigest()[:24]  # Take first 24 characters for a shorter code\n    \n    return registration_code\n\n# Example usage\nprint(generate_registration_code())