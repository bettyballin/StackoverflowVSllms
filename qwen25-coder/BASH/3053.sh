# Convert a private X.509 key to OpenSSH format\n   openssl pkcs8 -topk8 -inform pem -outform der -in x509.key -out openssh.key -nocrypt