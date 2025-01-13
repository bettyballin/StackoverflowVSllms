from cryptography.hazmat.primitives import hashes\nfrom cryptography.hazmat.primitives.asymmetric import padding, rsa\nfrom cryptography.hazmat.primitives import serialization\n\n# Generate private and public keys\nprivate_key = rsa.generate_private_key(\n    public_exponent=65537,\n    key_size=2048,\n)\n\npublic_key = private_key.public_key()\n\n# Serialize keys for storage\nprivate_pem = private_key.private_bytes(\n    encoding=serialization.Encoding.PEM,\n    format=serialization.PrivateFormat.PKCS8,\n    encryption_algorithm=serialization.NoEncryption()\n)\n\npublic_pem = public_key.public_bytes(\n    encoding=serialization.Encoding.PEM,\n    format=serialization.PublicFormat.SubjectPublicKeyInfo\n)\n\n# Save keys to files\nwith open("private_key.pem", "wb") as f:\n    f.write(private_pem)\nwith open("public_key.pem", "wb") as f:\n    f.write(public_pem)\n\n# Sign a file\nfile_to_sign = b"file content"\nsignature = private_key.sign(\n    file_to_sign,\n    padding.PSS(\n        mgf=padding.MGF1(hashes.SHA256()),\n        salt_length=padding.PSS.MAX_LENGTH\n    ),\n    hashes.SHA256()\n)\n\n# Save the signature\nwith open("file.sig", "wb") as f:\n    f.write(signature)