import re\n\ndef validate_serial_number(serial_number, parts=5, part_length=5):\n    pattern = re.compile(r'^([A-Z0-9]{' + str(part_length) + r'}-){' + str(parts-1) + r'}[A-Z0-9]{' + str(part_length) + r'}$')\n    return bool(pattern.match(serial_number))\n\n# Example usage\nis_valid = validate_serial_number(serial_number)\nprint(is_valid)