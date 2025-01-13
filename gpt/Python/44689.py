import re\n\ndef is_valid_tnt_tracking_number(tracking_number):\n    # Pattern for 9 numeric digits\n    pattern_9_digits = re.compile(r'^\d{9}$')\n    # Pattern for 13 characters (2 letters, 9 digits, 2 letters)\n    pattern_13_chars = re.compile(r'^[A-Z]{2}\d{9}[A-Z]{2}$')\n    \n    if pattern_9_digits.match(tracking_number) or pattern_13_chars.match(tracking_number):\n        return True\n    return False\n\n# Example usage\ntracking_number1 = "123456789"\ntracking_number2 = "GD123456789WW"\n\nprint(is_valid_tnt_tracking_number(tracking_number1))  # Output: True\nprint(is_valid_tnt_tracking_number(tracking_number2))  # Output: True