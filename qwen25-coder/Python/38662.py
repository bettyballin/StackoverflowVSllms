import bcrypt\n\ndef hash_password(password: str) -> bytes:\n    # Generate a salt and hash the password\n    salt = bcrypt.gensalt()\n    hashed = bcrypt.hashpw(password.encode('utf-8'), salt)\n    return hashed\n\ndef check_password(hashed_password: bytes, user_password: str) -> bool:\n    # Check if the hashed password matches the given password\n    return bcrypt.checkpw(user_password.encode('utf-8'), hashed_password)\n\n# Example usage\npassword = "StrongPassphrase123!"\nhashed_pass = hash_password(password)\nprint("Password Hash:", hashed_pass)\nis_valid = check_password(hashed_pass, "StrongPassphrase123!")\nprint("Is password correct?", is_valid)