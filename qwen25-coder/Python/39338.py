# Example of using bcrypt for password hashing in Python\nimport bcrypt\n\npassword = b"supersecret"\n# Generate a salt and hash the password\nhashed_password = bcrypt.hashpw(password, bcrypt.gensalt())\nprint(hashed_password)\n\n# To check the password:\nif bcrypt.checkpw(password, hashed_password):\n    print("Password matches")\nelse:\n    print("Invalid password")