from cryptography.fernet import Fernet\n\n# Example key generation (this should be securely stored)\nkey = Fernet.generate_key()\ncipher_suite = Fernet(key)\n\ndef encrypt_data(plain_text):\n    return cipher_suite.encrypt(str.encode(plain_text))\n\ndef decrypt_data(cipher_text):\n    return cipher_suite.decrypt(cipher_text).decode()\n\n# Example usage\naddress = "4th Street"\nencrypted_address = encrypt_data(address)\nprint(f"Encrypted Address: {encrypted_address}")\n\n# Store encrypted_address in the database\n# When querying, ensure you're searching for the exact match of encrypted data\n\n# Decrypting to view original (only if decrypted by authorized client)\ndecrypted_address = decrypt_data(encrypted_address)\nprint(f"Decrypted Address: {decrypted_address}")