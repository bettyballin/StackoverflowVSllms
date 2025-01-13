from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes\nfrom cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC\nfrom cryptography.hazmat.primitives import hashes\nfrom cryptography.hazmat.primitives.kdf.hkdf import HKDF\nfrom cryptography.hazmat.backends import default_backend\nfrom cryptography.hazmat.primitives import serialization\nfrom cryptography.hazmat.primitives.asymmetric import padding\nfrom base64 import urlsafe_b64encode, urlsafe_b64decode\nimport os\n\n# Generate a Data Encryption Key (DEK)\ndef generate_dek():\n    return os.urandom(32)  # 256-bit DEK\n\n# Encrypt data using DEK\ndef encrypt_data(dek, plaintext):\n    iv = os.urandom(16)\n    cipher = Cipher(algorithms.AES(dek), modes.CFB(iv), backend=default_backend())\n    encryptor = cipher.encryptor()\n    ciphertext = encryptor.update(plaintext) + encryptor.finalize()\n    return iv + ciphertext  # Prepend IV for decryption\n\n# Decrypt data using DEK\ndef decrypt_data(dek, ciphertext):\n    iv = ciphertext[:16]\n    actual_ciphertext = ciphertext[16:]\n    cipher = Cipher(algorithms.AES(dek), modes.CFB(iv), backend=default_backend())\n    decryptor = cipher.decryptor()\n    return decryptor.update(actual_ciphertext) + decryptor.finalize()\n\n# Encrypt DEK with a KEK\ndef encrypt_dek_with_kek(kek, dek):\n    cipher = Cipher(algorithms.AES(kek), modes.ECB(), backend=default_backend())\n    encryptor = cipher.encryptor()\n    return encryptor.update(dek) + encryptor.finalize()\n\n# Decrypt DEK with a KEK\ndef decrypt_dek_with_kek(kek, encrypted_dek):\n    cipher = Cipher(algorithms.AES(kek), modes.ECB(), backend=default_backend())\n    decryptor = cipher.decryptor()\n    return decryptor.update(encrypted_dek) + decryptor.finalize()\n\n# Example usage\nplaintext = b"Secret data"\ndek = generate_dek()\n\n# Encrypt the data\nencrypted_data = encrypt_data(dek, plaintext)\n\n# Encrypt the DEK with multiple KEKs\nkek1 = os.urandom(32)\nkek2 = os.urandom(32)\nkek3 = os.urandom(32)\nkek4 = os.urandom(32)\n\nencrypted_dek1 = encrypt_dek_with_kek(kek1, dek)\nencrypted_dek2 = encrypt_dek_with_kek(kek2, dek)\nencrypted_dek3 = encrypt_dek_with_kek(kek3, dek)\nencrypted_dek4 = encrypt_dek_with_kek(kek4, dek)\n\n# To decrypt the data, first decrypt the DEK using any of the KEKs\ndecrypted_dek = decrypt_dek_with_kek(kek1, encrypted_dek1)\n\n# Then use the decrypted DEK to decrypt the data\ndecrypted_data = decrypt_data(decrypted_dek, encrypted_data)\n\nassert decrypted_data == plaintext