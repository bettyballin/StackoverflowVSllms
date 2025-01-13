# Load the encrypted value from the INI file\nwith open("example.ini", "r") as f:\n    config = configparser.ConfigParser()\n    config.read_file(f)\n    encrypted_value = config["section"]["key"]\n\n# Decrypt the value\ndecrypted_value = cipher_suite.decrypt(encrypted_value.encode())\n\nprint(decrypted_value.decode())  # prints "my_secret_value"