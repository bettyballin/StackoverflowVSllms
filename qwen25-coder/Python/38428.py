from Crypto.Cipher import AES\nfrom Crypto.Random import get_random_bytes\nfrom Crypto.Util.Padding import pad, unpad\n\n# Key Generation (this should be securely shared between nodes)\nkey = get_random_bytes(32)  # AES-256 requires a 32-byte key\n\n# Initialize cipher in GCM mode with a random nonce\nnonce = get_random_bytes(12)  # GCM recommended nonce size is 12 bytes\ncipher = AES.new(key, AES.MODE_GCM, nonce=nonce)\n\n# Example message\nmessage = b'your_message_here'\n\n# Encrypt the message\nciphertext, tag = cipher.encrypt_and_digest(pad(message, AES.block_size))\n\n# Decrypt the message (on the receiving end)\ndecipher = AES.new(key, AES.MODE_GCM, nonce=nonce)\ndecipher.update(b"")\ntry:\n    plaintext = unpad(decipher.decrypt_and_verify(ciphertext, tag), AES.block_size)\n    print("Decrypted Message:", plaintext)\nexcept ValueError as ex:\n    print("Error decrypting message:", str(ex))