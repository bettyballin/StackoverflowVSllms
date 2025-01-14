import tempfile\n\ndef play_with_fd():\n    with tempfile.TemporaryFile() as f:\n        f.write(b'test data\n')  # Use bytes for writing in Python 3\n        f.write(b'most test data\n')  # Use bytes for writing in Python 3\n\n        f.seek(0)  # Move the file pointer to the beginning of the file\n        print('READ:', f.read().decode())  # Read and decode bytes to string\n\n        f.write(b'further data\n')  # Use bytes for writing in Python 3\n        f.seek(0)  # Move the file pointer back to the start after writing\n        print('READ:', f.read().decode())  # Read and decode bytes to string\n\n        f.write(b'even more\n')  # Use bytes for writing in Python 3\n        f.seek(0)  # Move the file pointer back to the start again\n        print('READ:', f.read().decode())  # Read and decode bytes to string\n\nif __name__ == '__main__':\n    play_with_fd()