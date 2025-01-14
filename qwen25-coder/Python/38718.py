from cryptography.fernet import Fernet\n\nclass SignatureStorage:\n    def __init__(self):\n        self.key = Fernet.generate_key()\n        self.cipher_suite = Fernet(self.key)\n\n    def encrypt_signature(self, signature_data):\n        """Encrypts the signature data."""\n        return self.cipher_suite.encrypt(signature_data)\n\n    def decrypt_signature(self, encrypted_signature):\n        """Decrypts the encrypted signature."""\n        return self.cipher_suite.decrypt(encrypted_signature)\n\n# Example usage\nsignature_storage = SignatureStorage()\noriginal_signature = b'signature_data_here'\nencrypted_signature = signature_storage.encrypt_signature(original_signature)\ndecrypted_signature = signature_storage.decrypt_signature(encrypted_signature)