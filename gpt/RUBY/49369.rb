require 'openssl'\n\n# Generate a new RSA key pair\nkey = OpenSSL::PKey::RSA.new(2048)\n\n# Encrypt the private key with a passphrase\ncipher = OpenSSL::Cipher.new('aes-256-cbc')\npassphrase = 'your_passphrase'\nencrypted_key = key.to_pem(cipher, passphrase)\n\n# Write the encrypted private key to a file\nFile.write('private_key', encrypted_key)\n\n# Write the public key to a file\npublic_key = key.public_key\nFile.write('public_key.pub', public_key.to_pem)