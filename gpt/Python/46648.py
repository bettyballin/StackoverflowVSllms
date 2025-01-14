import subprocess\n\n   def scan_file(file_path):\n       result = subprocess.run(['clamdscan', file_path], stdout=subprocess.PIPE)\n       if 'FOUND' in result.stdout.decode():\n           return False  # File is infected\n       return True  # File is clean\n\n   # Example usage\n   file_path = '/path/to/uploaded/file'\n   if scan_file(file_path):\n       print('File is clean')\n   else:\n       print('File is infected')