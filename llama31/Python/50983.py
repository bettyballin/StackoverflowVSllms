import argon2\n\n# Create an Argon2 instance with default settings\nargon2 = argon2.PasswordHasher()\n\n# Hash a password\nhashed_password = argon2.hash("mysecretpassword")\n\n# Verify a password\ntry:\n    argon2.verify(hashed_password, "mysecretpassword")\n    print("Password is valid")\nexcept argon2.exceptions.VerificationError:\n    print("Password is invalid")