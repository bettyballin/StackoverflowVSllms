import requests\nfrom cryptography.fernet import Fernet\n\nclass MyWebServiceClient:\n    def __init__(self, base_url, api_key):\n        self.base_url = base_url\n        self.api_key = api_key\n        self.session = requests.Session()\n    \n    def get_encrypted_data(self, endpoint):\n        """Fetch data from the given endpoint and decrypt it."""\n        url = f"{self.base_url}/{endpoint}"\n        headers = {'Authorization': f'Bearer {self.api_key}'}\n        response = self.session.get(url, headers=headers)\n        response.raise_for_status()  # Raises an HTTPError for bad responses\n        encrypted_data = response.content  # Assuming server returns encrypted content\n        decrypted_data = self.decrypt_data(encrypted_data)\n        return decrypted_data\n\n    def encrypt_data(self, data):\n        """Using symmetric encryption."""\n        key = Fernet.generate_key()\n        fernet = Fernet(key)\n        encrypted = fernet.encrypt(data.encode())\n        return encrypted, key\n\n    def decrypt_data(self, encrypted_data, key=None):\n        """Using symmetric decryption."""\n        if not key:\n            # Ideally use a shared secret or asymmetric encryption for keys\n            return "Decryption error: no key provided"\n        fernet = Fernet(key)\n        decrypted = fernet.decrypt(encrypted_data).decode()\n        return decrypted\n\n# Usage example\nclient = MyWebServiceClient("https://api.example.com", "your_api_key")\ndata = client.get_encrypted_data("protected/data")\nprint(data)