# Generate a private key\nopenssl genrsa -out foo.key 2048\n\n# Create a CSR with multiple SANs\nopenssl req -new -key foo.key -out foo.csr \\n-subj "/C=US/ST=State/L=City/O=Organization/OU=Department/CN=www.foo.com" \\n-reqexts SAN \\n-config <(cat /etc/pki/tls/openssl.cnf \\n    <(printf "[SAN]\nsubjectAltName=DNS:foo.com,DNS:www.foo.com"))