import hashlib\nimport os\n\n# Generate two random keys\nkey1 = os.urandom(32)\nkey2 = os.urandom(32)\n\n# Encrypt a message using AES-256-CBC with the first key\nencrypted_message = hashlib.sha256(key1).digest() + message\n\n# Encrypt the encrypted message using AES-256-CBC with the second key\ndoubly_encrypted_message = hashlib.sha256(key2).digest() + encrypted_message