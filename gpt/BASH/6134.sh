certutil -L -d /path/to/nssdb -n "mykey" -a | openssl x509 -noout -fingerprint