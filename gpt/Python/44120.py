import re\n\ndef extract_and_format(input_string):\n    pattern = r'(\d+)(?:$|c$)'\n    match = re.search(pattern, input_string)\n    \n    if match:\n        value = int(match.group(1))\n        if input_string.endswith('c'):\n            return value / 100.0\n        else:\n            return value\n    return None\n\n# Examples\nprint(extract_and_format("$10/$50"))  # Output: 50\nprint(extract_and_format("50c/70c"))  # Output: 0.7