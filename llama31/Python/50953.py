char = 'A'\nif ord(char) < 128:  # ASCII range is 0-127\n    ascii_value = ord(char)\n    print(ascii_value)  # Output: 65\nelse:\n    print("Character is not an ASCII character.")