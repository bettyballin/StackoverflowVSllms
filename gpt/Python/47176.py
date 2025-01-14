from Crypto.Cipher import AES\nfrom Crypto.Util.Padding import pad, unpad\nfrom Crypto.Random import get_random_bytes\n\n# Key and plaintext\nkey = get_random_bytes(16)\nplaintext = b'Example plaintext data to encrypt'\n\n# Initialization vector\niv = get_random_bytes(16)\n\n# Encryption\ncipher = AES.new(key, AES.MODE_CBC, iv)\nciphertext = cipher.encrypt(pad(plaintext, AES.block_size))\n\n# Decryption\ndecipher = AES.new(key, AES.MODE_CBC, iv)\ndecrypted_plaintext = unpad(decipher.decrypt(ciphertext), AES.block_size)\n\nprint(f'Ciphertext: {ciphertext.hex()}')\nprint(f'Decrypted: {decrypted_plaintext.decode()}')