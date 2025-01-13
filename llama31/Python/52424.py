def ascii_to_string(ascii_values):\n    if not ascii_values:\n        return ""\n    \n    try:\n        return ''.join(chr(i) for i in ascii_values)\n    except ValueError:\n        return "Invalid ASCII values"\n\nascii_values = [72, 101, 108, 108, 111]\nprint(ascii_to_string(ascii_values))