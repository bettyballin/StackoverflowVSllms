import uuid\n\ndef generate_nonce():\n    return str(uuid.uuid4())\n\n# Example usage\nnonce = generate_nonce()\nprint(f"Nonce: {nonce}")