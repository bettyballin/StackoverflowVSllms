import re\n\ndef preprocess(address):\n    # Normalize the address\n    address = address.lower().strip()\n    address = re.sub(r'\s+', ' ', address)\n    return address\n\ndef parse_address(address):\n    # Predefined regex patterns for address components\n    patterns = {\n        'street': r'(\d+\s+\w+(\s+\w+)*)',\n        'city': r'([a-zA-Z]+(?:[\s-][a-zA-Z]+)*)',\n        'state': r'\b([a-zA-Z]{2})\b'\n    }\n    \n    # Preprocess the address\n    address = preprocess(address)\n    \n    # Attempt to match each component\n    matches = {}\n    for component, pattern in patterns.items():\n        match = re.search(pattern, address)\n        if match:\n            matches[component] = match.group(0)\n            address = address.replace(match.group(0), '').strip()\n    \n    return matches\n\n# Example usage\naddress = "22 Main St, Kitchener, ON"\nparsed_address = parse_address(address)\nprint(parsed_address)