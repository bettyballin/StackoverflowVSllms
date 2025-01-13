from bcrypt import hashpw, gensalt, checkpw\n\n   def hash_password(password):\n       salt = gensalt()\n       hashed = hashpw(password.encode('utf-8'), salt)\n       return hashed\n\n   def verify_password(password, hashed):\n       return checkpw(password.encode('utf-8'), hashed)\n\n   # Example usage\n   hashed_pass = hash_password('my_secure_password')\n   is_valid = verify_password('my_secure_password', hashed_pass)