# Save the key to a file\nwith open('secret.key', 'wb') as key_file:\n    key_file.write(key)\n\n# Load the key from a file\nwith open('secret.key', 'rb') as key_file:\n    key = key_file.read()\n\nfernet = Fernet(key)