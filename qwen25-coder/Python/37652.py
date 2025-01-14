import pyclamd\n\n# Connect to ClamAV daemon\ncd = pyclamd.ClamdUnixSocket(path='/var/run/clamav/clamd.ctl')\n\ndef scan_file(file_path):\n    # Scan file with ClamAV\n    result = cd.scan_stream(open(file_path, 'rb').read())\n    if result is None:\n        print("File is clean.")\n    else:\n        print(f"Infected file: {file_path}")\n        print(result)\n\n# Example usage: scan_file('/path/to/uploaded/file.exe')