import hashlib\nimport os\n\ndef hash_password(password: str) -> str:\n    salt = os.urandom(16)  # Generate a 16-byte random salt\n    hash_obj = hashlib.pbkdf2_hmac('sha256', password.encode(), salt, 100000)\n    salt_hex = salt.hex()\n    hash_hex = hash_obj.hex()\n    return f"{salt_hex}${hash_hex}"\n\ndef verify_password(stored_password: str, provided_password: str) -> bool:\n    salt_hex, hash_hex = stored_password.split('$')\n    salt = bytes.fromhex(salt_hex)\n    hash_obj = hashlib.pbkdf2_hmac('sha256', provided_password.encode(), salt, 100000)\n    return hash_obj.hex() == hash_hex\n\n# Example usage\nhashed_password = hash_password("my_secure_password")\nprint(hashed_password)\nis_valid = verify_password(hashed_password, "my_secure_password")\nprint("Password is valid:", is_valid)