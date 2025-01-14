import random\nimport secrets\n\n# Insecure way\ninsecure_key = random.getrandbits(128)\nprint("Insecure Key:", insecure_key)\n\n# Secure way\nsecure_key = secrets.randbits(128)\nprint("Secure Key:", secure_key)