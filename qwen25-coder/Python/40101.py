try:\n    data.encode('utf-8').decode('utf-8')\nexcept UnicodeError:\n    # Handle invalid UTF-8 encoding