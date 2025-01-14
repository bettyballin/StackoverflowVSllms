import random\nimport string\n\ndef makeKey():\n    # Generate a 5-character alphanumeric key\n    return ''.join(random.choices(string.ascii_letters + string.digits, k=5))\n\ndef keyExists(key):\n    # Mock function to simulate checking if the key exists\n    existing_keys = ['a1B2C', '3dE4f', 'g5H6i']  # Example list of existing keys\n    return key in existing_keys\n\ndef generateUniqueKey():\n    unique_key = None\n    while True:\n        candidate_key = makeKey()\n        if not keyExists(candidate_key):\n            unique_key = candidate_key\n            break\n    return unique_key\n\n# Generate a unique key\nunique_key = generateUniqueKey()\nprint("Generated Unique Key:", unique_key)