# IIS configuration for HTTPS (simplified)\n   netsh http add sslcert ipport=0.0.0.0:443 certhash=<your-cert-hash> appid={your-app-guid}