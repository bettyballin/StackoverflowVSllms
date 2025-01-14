import hmac\nimport hashlib\n\ndef verify_hmac(received_hmac, nonce, stored_secret):\n    expected_hmac = hmac.new(stored_secret.encode(), nonce.encode(), hashlib.sha256).hexdigest()\n    return hmac.compare_digest(expected_hmac, received_hmac)\n\n# Example usage:\nreceived_hmac_from_client = "client_computed_hmac"  # This would be received from the client\nnonce_sent_to_client = "server_nonce_123"\nstored_password_hash_for_user = "expected_stored_password_hash"\n\nis_valid = verify_hmac(received_hmac_from_client, nonce_sent_to_client, stored_password_hash_for_user)