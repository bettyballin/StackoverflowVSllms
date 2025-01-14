def xor_decrypt(ciphertext, key):\n    return ''.join(chr(b ^ key) for b in ciphertext)\n\nciphertext1 = bytes.fromhex('b50102c1e3')\nplaintext1 = '3543921'\n\n# Trying XOR with a single byte key (assuming simple key-based XOR)\nfor k in range(256):\n    decrypted_text = xor_decrypt(ciphertext1, k)\n    if all(c.isdigit() or c == '.' for c in decrypted_text) and plaintext1 in decrypted_text:\n        print(f"Potential key found: {k} (0x{k:02x})")\n        break