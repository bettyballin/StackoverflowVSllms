# Generate a key pair\nopenssl genrsa -out private_key.pem 2048\n\n# Encrypt the private key\nopenssl rsa -in private_key.pem -out encrypted_private_key.pem -passout pass:my_secret_password\n\n# Store the public key in source control\ncp public_key.pem /path/to/source/control\n\n# Store the encrypted private key securely\nmv encrypted_private_key.pem /path/to/secure/storage