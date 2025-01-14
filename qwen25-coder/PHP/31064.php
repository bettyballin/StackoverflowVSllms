// Generate a random salt\n$salt = bin2hex(random_bytes(16));\n\n// Hash the password with the salt using a secure hashing function like bcrypt\n$hashed_password = password_hash($plaintext_password . $salt, PASSWORD_BCRYPT);\n\n// Store both the hash and the salt securely (e.g., in your database)