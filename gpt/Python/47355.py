from django.utils.text import get_valid_filename\n    \n    def handle_uploaded_file(f):\n        file_name = get_valid_filename(f.name)\n        with open(f'/path/to/upload/{file_name}', 'wb+') as destination:\n            for chunk in f.chunks():\n                destination.write(chunk)