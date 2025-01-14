import bcrypt\n\ndef hash_secret_answer(secret_answer):\n    # Generate a salt\n    salt = bcrypt.gensalt()\n    # Hash the secret answer with the generated salt\n    hashed = bcrypt.hashpw(secret_answer.encode('utf-8'), salt)\n    return hashed\n\ndef check_secret_answer(stored_hash, user_input):\n    # Check the provided secret answer against the stored hash\n    return bcrypt.checkpw(user_input.encode('utf-8'), stored_hash)\n\n# Example usage\nsecret_answer = "MySecretAnswer123!"\nhashed_answer = hash_secret_answer(secret_answer)\nprint("Hashed Secret Answer:", hashed_answer)\n\nis_correct = check_secret_answer(hashed_answer, "MySecretAnswer123!")\nprint("Is the secret answer correct?", is_correct)