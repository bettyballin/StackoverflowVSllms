import os\nimport secrets\n\ndef secure_delete_windows(folder_path):\n    for filename in os.listdir(folder_path):\n        file_path = os.path.join(folder_path, filename)\n        if os.path.isfile(file_path) or os.path.islink(file_path):\n            with open(file_path, 'ba+') as f:\n                length = f.tell()\n                f.seek(0)\n                # Overwrite the file content\n                for _ in range(3):  # Perform overwrite three times\n                    f.write(secrets.token_bytes(length))\n                f.truncate()  # Ensure to truncate the file after overwriting\n            os.remove(file_path)\n\n# Example usage\nsecure_delete_windows('C:\\path\\to\\folder')