from Crypto.Cipher import AES\n\n# Set the key and plaintext\nkey = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'\nplaintext = b'GIF87a...'\n\n# Create an AES cipher object\ncipher = AES.new(key, AES.MODE_ECB)\n\n# Encrypt the plaintext\nciphertext = cipher.encrypt(plaintext)\n\nprint(ciphertext.hex())