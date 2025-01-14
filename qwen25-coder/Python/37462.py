# Example of using the `os` module along with `cryptography` for encryption - third-party in Python\nfrom cryptography.fernet import Fernet\n\nkey = Fernet.generate_key()\ncipher_suite = Fernet(key)\ncipher_text = cipher_suite.encrypt(b"Secure message")\nplain_text = cipher_suite.decrypt(cipher_text)\n\nprint(f"Ciphertext: {cipher_text}")\nprint(f"Plaintext: {plain_text}")