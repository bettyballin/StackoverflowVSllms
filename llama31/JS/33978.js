// Client-side (iframe)\nlocalStorage.setItem('sessionToken', tokenReceivedFromServer);\n\n// Server-side (verify token on each request)\nif (tokenReceivedFromClient === expectedToken) {\n  // Session is valid, proceed with request\n}