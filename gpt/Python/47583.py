import bcrypt\n\n# Hash a password with salt\ndef hash_password(password):\n    # Generate a salt\n    salt = bcrypt.gensalt()\n    # Hash the password with the salt\n    hashed = bcrypt.hashpw(password.encode('utf-8'), salt)\n    return hashed\n\n# Check if a given password matches the stored hash\ndef check_password(stored_hash, password):\n    return bcrypt.checkpw(password.encode('utf-8'), stored_hash)\n\n# Example usage\npassword = 'blowfish'\nhashed_password = hash_password(password)\n\nprint(hashed_password)\n\n# Verify password\nis_correct = check_password(hashed_password, 'blowfish')\nprint(is_correct)  # Should print True