import hmac\nimport hashlib\nimport base64\n\ndef compute_hmac(nonce, secret):\n    return hmac.new(secret.encode(), nonce.encode(), hashlib.sha256).hexdigest()\n\n# Example usage:\nusername = "user1"\nnonce_from_server = "server_nonce_123"  # This would be received from the server\npassword_for_user = "secure_password"\n\nhmac_to_send = compute_hmac(nonce_from_server, password_for_user)