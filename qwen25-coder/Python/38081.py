import sys\n\n   try:\n       with open('/path/to/output.txt', 'w') as f:\n           f.write('Some data')\n           f.flush()  # Force write to disk\n       print("Data written successfully")\n       sys.stdout.flush()\n   except Exception as e:\n       print(f"An error occurred: {e}", file=sys.stderr)\n       sys.stderr.flush()