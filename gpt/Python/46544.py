#!/usr/bin/env python3\n\nimport subprocess\nimport sys\nfrom Crypto.Cipher import AES\nimport base64\nimport getpass\n\ndef decrypt_and_run(encrypted_script_path):\n    password = getpass.getpass("Enter decryption password: ")\n    key = password.encode('utf-8').ljust(32, b'\0')\n\n    with open(encrypted_script_path, 'rb') as f:\n        encrypted_data = f.read()\n\n    cipher = AES.new(key, AES.MODE_ECB)\n    decrypted_data = cipher.decrypt(base64.b64decode(encrypted_data)).decode('utf-8')\n\n    process = subprocess.Popen(decrypted_data, shell=True)\n    process.communicate()\n\nif __name__ == "__main__":\n    if len(sys.argv) < 2:\n        print("Usage: decryptandrun <encrypted_script_path>")\n        sys.exit(1)\n\n    decrypt_and_run(sys.argv[1])