def is_ascii(s):\n    try:\n        s.encode('ascii')\n        return True\n    except UnicodeEncodeError:\n        return False