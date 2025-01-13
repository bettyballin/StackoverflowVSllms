import secrets\nimport hashlib\nimport hmac\n\ndef generate_token(username, password, authkey):\n    token = secrets.token_urlsafe(32)\n    hashed_token = hashlib.sha256(token.encode()).hexdigest()\n    signed_token = hmac.new(b'secret_key', hashed_token.encode(), hashlib.sha256).hexdigest()\n    return signed_token\n\n# Generate a token for the user\ntoken = generate_token('username', 'password', 'authkey')