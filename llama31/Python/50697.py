import ctypes\nimport getpass\n\n# Get password from user\npassword = getpass.getpass()\n\n# Convert password to bytes\npassword_bytes = password.encode('utf-8')\n\n# Get the memory address of the password bytes\npassword_addr = ctypes.addressof(ctypes.c_char.from_buffer(password_bytes))\n\n# Overwrite the password with zeros\nctypes.memset(password_addr, 0, len(password_bytes))\n\n# Now the password is securely erased from memory