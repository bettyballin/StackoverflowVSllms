from cryptography.fernet import Fernet\n\n# Generate a key for encryption\nkey = Fernet.generate_key()\ncipher_suite = Fernet(key)\n\n# Save the key to a file for later use\nwith open('secret.key', 'wb') as key_file:\n    key_file.write(key)\n\n# Encrypt a file\ndef encrypt_file(input_file, output_file):\n    with open(input_file, 'rb') as file:\n        file_data = file.read()\n\n    encrypted_data = cipher_suite.encrypt(file_data)\n\n    with open(output_file, 'wb') as file:\n        file.write(encrypted_data)\n\n# Decrypt a file\ndef decrypt_file(input_file, output_file):\n    with open(input_file, 'rb') as file:\n        encrypted_data = file.read()\n\n    decrypted_data = cipher_suite.decrypt(encrypted_data)\n\n    with open(output_file, 'wb') as file:\n        file.write(decrypted_data)\n\n# Example usage\nencrypt_file('example.txt', 'example.encrypted')\ndecrypt_file('example.encrypted', 'example.decrypted.txt')