import secrets\nimport bcrypt\n\ndef hash_password(password):\n    salt = secrets.token_bytes(16)\n    hashed_password = bcrypt.hashpw(password.encode('utf-8'), salt)\n    return salt.hex(), hashed_password.hex()\n\ndef verify_password(stored_salt, stored_hash, provided_password):\n    salt = bytes.fromhex(stored_salt)\n    hashed_password = bcrypt.hashpw(provided_password.encode('utf-8'), salt)\n    return hashed_password.hex() == stored_hash