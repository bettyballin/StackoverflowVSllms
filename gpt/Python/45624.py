ascii_str = r'\u003cfoo/\u003e'\nunicode_str = ascii_str.encode('ascii').decode('unicode-escape')\nprint(unicode_str)  # Output: <foo/>