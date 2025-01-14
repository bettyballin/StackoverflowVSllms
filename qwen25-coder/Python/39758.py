from Crypto.PublicKey import RSA\nfrom Crypto.Random import get_random_bytes\nfrom Crypto.Cipher import PKCS1_OAEP\n\n# Generate RSA keys\nkey = RSA.generate(2048)\nprivate_key = key.export_key()\npublic_key = key.publickey().export_key()\n\n# Save keys to files\nwith open("private.pem", "wb") as f:\n    f.write(private_key)\n\nwith open("receiver.pem", "wb") as f:\n    f.write(public_key)\n\n# Load public key for encryption\nrecipient_key = RSA.import_key(open("receiver.pem").read())\ncipher_rsa = PKCS1_OAEP.new(recipient_key)\ndata = 'Hello World!'.encode()\nencrypted_data = cipher_rsa.encrypt(data)\n\n# Load private key for decryption\nprivate_key = RSA.import_key(open("private.pem").read())\ncipher_rsa = PKCS1_OAEP.new(private_key)\ndecrypted_message = cipher_rsa.decrypt(encrypted_data).decode()\n\nprint(decrypted_message)