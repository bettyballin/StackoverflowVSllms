# Python Example\nimport requests\n\nclass RestClient:\n    def fetch_data(self, url):\n        response = requests.get(url)\n        if not response.ok:\n            raise Exception(f"HTTP error occurred: {response.status_code}")\n        return response.json()