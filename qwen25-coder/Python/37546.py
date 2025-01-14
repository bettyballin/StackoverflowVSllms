import bcrypt\n\ndef hash_password(password):\n    # Generate a salt\n    salt = bcrypt.gensalt()\n    # Hash the password with the generated salt\n    hashed_password = bcrypt.hashpw(password.encode('utf-8'), salt)\n    return hashed_password  # Store this value in your DBMS\n\ndef check_password(stored_hash, provided_password):\n    # Compare the provided password against the stored hash\n    return bcrypt.checkpw(provided_password.encode('utf-8'), stored_hash)\n\n# Example usage:\npassword = "secure_password123"\nhashed_password = hash_password(password)\nprint(f"Hashed Password: {hashed_password}")\n\n# Verify a password\nis_correct = check_password(hashed_password, password)\nprint(f"Password is correct: {is_correct}")