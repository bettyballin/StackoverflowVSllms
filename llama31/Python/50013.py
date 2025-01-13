class ProgressFileReader:\n    def __init__(self, file_path, callback):\n        self.file_path = file_path\n        self.callback = callback\n        self.file_size = os.path.getsize(file_path)\n        self.bytes_read = 0\n\n    def read(self, chunk_size=1024):\n        with open(self.file_path, 'rb') as file:\n            while True:\n                chunk = file.read(chunk_size)\n                if not chunk:\n                    break\n                self.bytes_read += len(chunk)\n                self.callback(self.bytes_read / self.file_size)\n                yield chunk\n\n# Example usage:\ndef progress_callback(progress):\n    print(f"Loaded {progress*100:.2f}%")\n\nreader = ProgressFileReader('large_file.txt', progress_callback)\nfor chunk in reader.read():\n    # Process the chunk\n    pass