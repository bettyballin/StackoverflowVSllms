# Create a Certificate Authority (CA)\nopenssl genrsa -out ca.key 2048\nopenssl req -x509 -new -nodes -key ca.key -subj "/C=US/ST=State/L=Locality/O=Organization/CN=Root CA" -out ca.crt\n\n# Generate a client certificate\nopenssl genrsa -out client.key 2048\nopenssl req -new -key client.key -subj "/C=US/ST=State/L=Locality/O=Organization/CN=Client" -out client.csr\nopenssl x509 -req -in client.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out client.crt -days 365