import magic\n\ndef get_file_type(file_path):\n    mime = magic.Magic(mime=True)\n    return mime.from_file(file_path)\n\n# Example usage:\nfile_path = 'example.txt'\nprint(f"The MIME type of {file_path} is: {get_file_type(file_path)}")