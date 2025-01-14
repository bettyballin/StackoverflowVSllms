import hmac\nimport hashlib\n\ndef generate_hmac(secret_key, message):\n    return hmac.new(secret_key.encode(), message.encode(), hashlib.sha256).hexdigest()\n\n# Example usage\nsecret_key = 'your_secret_key'\nchallenge = 'unique_challenge_from_server'\nclient_response = generate_hmac(secret_key, challenge)\n\nprint("Client response to server:", client_response)