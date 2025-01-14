def validate_jwt(token, secret):\n    try:\n        payload = jwt.decode(token, secret, algorithms=['HS256'])\n        return payload\n    except jwt.ExpiredSignatureError:\n        return None\n    except jwt.InvalidTokenError:\n        return None