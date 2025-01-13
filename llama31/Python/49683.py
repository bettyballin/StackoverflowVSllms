import secrets\nimport hashlib\n\ndef hash_password(password):\n    salt = secrets.token_bytes(16)\n    hashed_password = hashlib.pbkdf2_hmac('sha256', password.encode('utf-8'), salt, 100000)\n    return salt + hashed_password\n\n# Example usage:\npassword = "mysecretpassword"\nhashed_password = hash_password(password)\nprint(hashed_password.hex())