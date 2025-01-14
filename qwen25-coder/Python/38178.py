def parse_large_community(data):\n    # Each large community is 8 bytes long: [AS number (4 bytes)]+[Local Data Part 1 (2 bytes)]+[Local Data Part 2 (2 bytes)]\n    if len(data) % 8 != 0:\n        raise ValueError("Invalid data length for Large Community attribute")\n    \n    communities = []\n    for i in range(0, len(data), 8):\n        as_number = int.from_bytes(data[i:i+4], 'big')\n        local_data_1 = int.from_bytes(data[i+4:i+6], 'big')\n        local_data_2 = int.from_bytes(data[i+6:i+8], 'big')\n        communities.append((as_number, local_data_1, local_data_2))\n    \n    return communities\n\n# Example usage with hypothetical binary data\nbinary_data = b'\x00\x01\x34\xc0\x00\x00\x00\x01'  # AS6870:0:1\nparsed_communities = parse_large_community(binary_data)\nprint(parsed_communities)  # Output: [(6870, 0, 1)]