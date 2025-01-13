# Simplified example of privacy-preserving addition in a machine learning context\nimport pyseal as seal\n\n# Parameters setup same as above...\n\n# Encrypted input data\ndata1 = seal.Plaintext("10")\ndata2 = seal.Plaintext("20")\nencrypted_data1 = seal.Ciphertext()\nencrypted_data2 = seal.Ciphertext()\nencryptor.encrypt(data1, encrypted_data1)\nencryptor.encrypt(data2, encrypted_data2)\n\n# Encrypted model computation (e.g., summing features)\nencrypted_sum = seal.Ciphertext()\nevaluator.add(encrypted_data1, encrypted_data2, encrypted_sum)\n\n# Decrypt the result\nplain_sum = seal.Plaintext()\ndecryptor.decrypt(encrypted_sum, plain_sum)\nprint(f"Decrypted sum: {plain_sum.to_string()}")  # Output: 30