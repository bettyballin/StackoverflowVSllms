from Crypto.Signature import pss\nfrom Crypto.Hash import SHA256\nfrom Crypto.PublicKey import RSA\nfrom Crypto import Random\n\n# Generate RSA key pair\nkey = RSA.generate(2048)\npublic_key = key.publickey()\n\n# Sign a message\nmessage = b'This is a message to sign'\nh = SHA256.new(message)\nsignature = pss.new(key).sign(h)\n\nprint(f'Signature: {signature}')\n\n# Verify the signature\nverifier = pss.new(public_key)\ntry:\n    verifier.verify(h, signature)\n    print("The signature is valid.")\nexcept (ValueError, TypeError):\n    print("The signature is not valid.")