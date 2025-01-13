import hashlib\nimport os\nimport binascii\n\ndef hash_password(password):\n    # Generate a random salt\n    salt = os.urandom(16)\n    # Hash the password with the salt\n    hashed_password = hashlib.pbkdf2_hmac('sha256', password.encode('utf-8'), salt, 100000)\n    # Store the salt and hashed password as a single string\n    return binascii.hexlify(salt + hashed_password).decode('utf-8')\n\ndef verify_password(stored_password_hash, provided_password):\n    # Extract the salt from the stored password hash\n    salt = binascii.unhexlify(stored_password_hash[:32])\n    # Hash the provided password with the same salt\n    hashed_password = hashlib.pbkdf2_hmac('sha256', provided_password.encode('utf-8'), salt, 100000)\n    # Compare the resulting hash with the stored hash\n    return binascii.hexlify(hashed_password).decode('utf-8') == stored_password_hash[32:]