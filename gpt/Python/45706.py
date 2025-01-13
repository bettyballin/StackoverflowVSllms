from cryptography.hazmat.primitives import hashes\n   from cryptography.hazmat.primitives.asymmetric import padding, rsa\n   from cryptography.hazmat.primitives.serialization import load_pem_private_key\n   from cryptography.hazmat.backends import default_backend\n\n   # Load the private key\n   with open('private_key.pem', 'rb') as key_file:\n       private_key = load_pem_private_key(key_file.read(), password=None, backend=default_backend())\n\n   # Binary stream to be signed\n   binary_stream = b'This is a binary stream that needs to be signed'\n\n   # Sign the binary stream\n   signature = private_key.sign(\n       binary_stream,\n       padding.PSS(\n           mgf=padding.MGF1(hashes.SHA256()),\n           salt_length=padding.PSS.MAX_LENGTH\n       ),\n       hashes.SHA256()\n   )\n\n   # Save the signature to a file\n   with open('signature.bin', 'wb') as signature_file:\n       signature_file.write(signature)\n\n   print("Binary stream signed and saved to signature.bin")