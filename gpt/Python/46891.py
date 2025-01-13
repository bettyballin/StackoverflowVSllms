import os\nfrom cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC\nfrom cryptography.hazmat.primitives import hashes\nfrom cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes\nfrom cryptography.hazmat.backends import default_backend\n\n# Generate a random salt\nsalt = os.urandom(16)\n\n# Derive a key using PBKDF2HMAC\npassword = b'my secure password'  # Replace this with your actual password\nkdf = PBKDF2HMAC(\n    algorithm=hashes.SHA256(),\n    length=32,\n    salt=salt,\n    iterations=100000,\n    backend=default_backend()\n)\nkey = kdf.derive(password)\n\n# Generate a random IV\niv = os.urandom(16)\n\n# Encrypt the data\nplaintext = b'secret data to encrypt'\ncipher = Cipher(algorithms.AES(key), modes.CFB(iv), backend=default_backend())\nencryptor = cipher.encryptor()\nciphertext = encryptor.update(plaintext) + encryptor.finalize()\n\n# Combine salt, IV, and ciphertext for transmission/storage\nencrypted_data = salt + iv + ciphertext\n\n# To decrypt, extract the salt and IV and derive the same key\nextracted_salt = encrypted_data[:16]\nextracted_iv = encrypted_data[16:32]\nextracted_ciphertext = encrypted_data[32:]\n\nkdf = PBKDF2HMAC(\n    algorithm=hashes.SHA256(),\n    length=32,\n    salt=extracted_salt,\n    iterations=100000,\n    backend=default_backend()\n)\nkey = kdf.derive(password)\n\ncipher = Cipher(algorithms.AES(key), modes.CFB(extracted_iv), backend=default_backend())\ndecryptor = cipher.decryptor()\ndecrypted_data = decryptor.update(extracted_ciphertext) + decryptor.finalize()\n\nassert decrypted_data == plaintext