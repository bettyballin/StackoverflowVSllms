import hashlib\n\n# Define a password and salt\npassword = "bar"\nsalt = "foo"\n\n# Compute the hashed password\nhashed_password = hashlib.md5((salt + password).encode()).hexdigest()\n\n# Print the results\nprint("Salt:", salt)\nprint("Hashed Password:", hashed_password)