# Generate a private key with 2048 bits\nopenssl genpkey -algorithm RSA -out myprivate.key -aes256 -pkeyopt rsa_keygen_bits:2048\n\n# Create a self-signed certificate using the generated key\nopenssl req -x509 -new -nodes -key myprivate.key -sha256 -days 365 -out mycertificate.crt