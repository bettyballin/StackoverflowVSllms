from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes\nfrom cryptography.hazmat.primitives import padding\nimport os\n\n# Key and IV generation\nkey = os.urandom(32)  # 256-bit key\niv = os.urandom(12)  # 96-bit IV\n\n# Create a cipher context\ncipher = Cipher(algorithms.AES(key), modes.GCM(iv), backend=None)\n\n# Encrypt a message\nmessage = b"Hello, World!"\nencryptor = cipher.encryptor()\npadder = padding.PKCS7(cipher.algorithm.block_size).padder()\npadded_data = padder.update(message) + padder.finalize()\nencrypted_message = encryptor.update(padded_data) + encryptor.finalize()\n\n# Decrypt the message\ndecryptor = cipher.decryptor()\ndecrypted_padded_message = decryptor.update(encrypted_message) + decryptor.finalize()\nunpadder = padding.PKCS7(cipher.algorithm.block_size).unpadder()\nmessage = unpadder.update(decrypted_padded_message) + unpadder.finalize()\n\nprint(message.decode())  # prints "Hello, World!"