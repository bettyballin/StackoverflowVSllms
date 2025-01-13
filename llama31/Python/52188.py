import secrets\nimport hashlib\n\n# Generate a unique token\ntoken = secrets.token_urlsafe(32)\n\n# Create a verification hash\nemail = "user@example.com"\nverification_hash = hashlib.pbkdf2_hmac(\n    "sha256", token.encode(), email.encode(), 100000\n).hex()\n\n# Store the token and verification hash in the database\n# ...\n\n# When the user clicks the activation link\n# ...\n\n# Verify the hash\nstored_token = get_token_from_db(email)\nstored_verification_hash = get_verification_hash_from_db(email)\n\nif verification_hash == hashlib.pbkdf2_hmac(\n    "sha256", stored_token.encode(), email.encode(), 100000\n).hex():\n    # Activate the account\n    # ...