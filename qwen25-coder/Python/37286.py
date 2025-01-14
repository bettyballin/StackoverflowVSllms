import os\nimport hmac\nimport hashlib\n\n# Secret string S\nsecret_key = b'your_secret_string'\n\ndef generate_token():\n    # Generate random string K\n    k = os.urandom(32)  # 256 bit random number, adjust as needed\n    # Create HMAC of K using secret_key\n    h = hmac.new(secret_key, k, hashlib.sha256).hexdigest()\n    # Token is combination of K and H\n    token = k + h.encode('utf-8')  # Encoding to bytes for storage or transmission\n    return token\n\ndef validate_token(token):\n    k = token[:32]  # Assuming 32 byte random string\n    provided_hmac = token[32:]\n    expected_hmac = hmac.new(secret_key, k, hashlib.sha256).hexdigest().encode('utf-8')\n    # Secure comparison to prevent timing attacks\n    return hmac.compare_digest(expected_hmac, provided_hmac)