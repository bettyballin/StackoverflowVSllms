from cryptography.hazmat.primitives import serialization, asymmetric, padding\nfrom cryptography.hazmat.primitives.asymmetric.rsa import RSAPrivateKey\nfrom cryptography.hazmat.primitives.asymmetric.padding import OAEP\nfrom cryptography.hazmat.primitives hashes import SHA256\n\n# Function to load RSA private key from a string with passphrase\ndef load_private_key(private_key_str, passphrase):\n    return serialization.load_pem_private_key(\n        private_key_str.encode(),\n        password=passphrase.encode(),\n        backend=default_backend()\n    )\n\n# Function to decrypt a message using the loaded private key\ndef decrypt_message(private_key: RSAPrivateKey, encrypted_data):\n    return private_key.decrypt(\n        encrypted_data,\n        OAEP(\n            mgf=padding.MGF1(algorithm=hashes.SHA256()),\n            algorithm=hashes.SHA256(),\n            label=None\n        )\n    )\n\n# Example usage\nprivate_key_str = b"""-----BEGIN ENCRYPTED PRIVATE KEY-----\n...\n-----END ENCRYPTED PRIVATE KEY-----"""\npassphrase = 'your-passphrase'\nencrypted_data = b'...'  # The data you want to decrypt\n\nprivate_key = load_private_key(private_key_str, passphrase)\ndecrypted_data = decrypt_message(private_key, encrypted_data)\nprint(decrypted_data.decode())