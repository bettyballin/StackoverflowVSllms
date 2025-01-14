import os\n\nclass ProgressFileReader:\n    def __init__(self, filename, callback):\n        self.file = open(filename, 'rb')\n        self.total_size =	os.path.getsize(filename)\n        self.bytes_read = 0\n        self.callback = callback\n\n    def read(self, size=-1):\n        data = self.file.read(size)\n        if data:\n            self.bytes_read += len(data)\n            progress = (self.bytes_read / self.total_size) * 100\n            self.callback(progress)\n        return data\n\n    def close(self):\n        self.file.close()\n\n    def __enter__(self):\n        return self\n\n    def __exit__(self, exc_type, exc_val, exc_tb):\n        self.close()\n\n# Example usage:\ndef print_progress(progress):\n    print(f"Progress: {progress:.2f}%")\n\nwith ProgressFileReader('example.txt', print_progress) as reader:\n    while True:\n        chunk = reader.read(1024)\n        if not chunk:\n            break\n        # Process the chunk here