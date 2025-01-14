import jwt\nimport datetime\n\n# Define a secret key known only to your game server and client application.\nSECRET_KEY = 'your_super_secret_key_here'\n\ndef encode_score(user_id, score):\n    # Use current timestamp + user ID and user's current score to generate token\n    payload = {\n        'user_id': user_id,\n        'score': score,\n        'iat': datetime.datetime.utcnow()\n    }\n    # Generate a JWT encoded with HMAC\n    return jwt.encode(payload, SECRET_KEY, algorithm='HS256')\n\ndef decode_score(encoded_score):\n    try:\n        # Verify the token's signature and validity using the same secret key.\n        decoded = jwt.decode(encoded_score, SECRET_KEY, algorithms=['HS256'])\n        return decoded\n    except Exception as e:\n        print(f"Failed to decode score: {e}")\n        return None\n\n# Example usage:\nencoded = encode_score(12345, 9876)\nprint("Encoded Score Token:", encoded)\n\ndecoded = decode_score(encoded)\nif decoded:\n    print("Decoded User ID:", decoded['user_id'])\n    print("Decoded Score:", decoded['score'])