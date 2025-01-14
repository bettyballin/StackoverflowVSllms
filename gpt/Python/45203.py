from Crypto.Cipher import AES\nfrom Crypto.Random import get_random_bytes\n\ndata = b'This is 16 bytes'\nkey = get_random_bytes(32) # 256-bit key\niv = get_random_bytes(12) # 96-bit IV for GCM\n\ncipher = AES.new(key, AES.MODE_GCM, nonce=iv)\nciphertext, tag = cipher.encrypt_and_digest(data)\n\nprint(f"Ciphertext: {ciphertext}")\nprint(f"Tag: {tag}")