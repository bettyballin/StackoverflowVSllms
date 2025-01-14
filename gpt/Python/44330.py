import re\n\ndef parse_email(email_text):\n    data = {}\n    locations = re.split(r'\n\s*\n', email_text.strip())\n    \n    for location_block in locations:\n        lines = location_block.split("\n")\n        location = lines[0].strip()\n        products = lines[1].split()\n        prices = lines[2].split()\n        \n        data[location] = {}\n        for i, product in enumerate(products):\n            data[location][product] = prices[i]\n    \n    return data\n\n# Example usage:\nemail_text = """\n    This is example text that could be many lines long...\n\n    Location 1\n    Product 1     Product 2     Product 3\n    $20.99        $21.99        $33.79\n\n    Location 2\n    Product 1     Product 2     Product 3\n    $24.99        $22.88        $35.59\n"""\n\nparsed_data = parse_email(email_text)\nprint(parsed_data)