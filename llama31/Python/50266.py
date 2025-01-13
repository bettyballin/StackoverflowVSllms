from cryptography.hazmat.primitives import serialization, hashes\nfrom cryptography.hazmat.primitives.asymmetric import padding\nfrom cryptography.hazmat.backends import default_backend\n\npublic_key = b"""\n-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDfG4IuFO2h/LdDNmonwGNw5srW\nnUEWzoBrPRF1NM8LqpOMD45FAPtZ1NmPtHGo0BAS1UsyJEGXx0NPJ8Gw1z+huLrl\nXnAVX5B4ec6cJfKKmpL/l94WhP2v8F3OGWrnaEX1mLMoxe124Pcfamt0SPCGkeal\nVvXw13PLINE/YptjkQIDAQAB\n-----END PUBLIC KEY-----\n"""\n\npublic_key_loaded = serialization.load_pem_public_key(\n    public_key,\n    backend=default_backend()\n)\n\ndef verify_signature(data: bytes, signature: bytes) -> bool:\n    try:\n        public_key_loaded.verify(\n            signature,\n            data,\n            padding.PKCS1v15(),\n            hashes.SHA1()\n        )\n        return True\n    except:\n        return False\n\n# Example usage\ndata = b"Your data here"\nsignature = b"Your signature here"\n\nis_valid = verify_signature(data, signature)\nprint(is_valid)