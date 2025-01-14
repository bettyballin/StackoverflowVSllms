def round_to_nearest(number, base=100):\n    return round(number / base) * base\n\n# Test cases\nprint(round_to_nearest(1244))  # Output: 1200\nprint(round_to_nearest(1254))  # Output: 1300\nprint(round_to_nearest(123))   # Output: 100\nprint(round_to_nearest(178))   # Output: 200\nprint(round_to_nearest(1576))  # Output: 1600\nprint(round_to_nearest(1449))  # Output: 1400\nprint(round_to_nearest(123456))# Output: 123500\nprint(round_to_nearest(654321))# Output: 654300\nprint(round_to_nearest(23))    # Output: 0\nprint(round_to_nearest(83))    # Output: 100