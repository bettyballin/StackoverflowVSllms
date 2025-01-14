import random\n\ndef find_random_point(x1, y1, x2, y2):\n    # Calculate the slope (m)\n    m = (y2 - y1) / (x2 - x1)\n    \n    # Calculate the y-intercept (b)\n    b = y1 - m * x1\n    \n    # Select a random x-coordinate between x1 and x2\n    x3 = random.randint(min(x1, x2), max(x1, x2))\n    \n    # Calculate the y-coordinate using the line equation y = mx + b\n    y3 = m * x3 + b\n    \n    # Since we want both points as integers, round y3 to the nearest integer\n    y3 = round(y3)\n    \n    return x3, y3\n\n# Example usage\nx1, y1 = 1952805748, 0\nx2, y2 = 7, 142\n\nx3, y3 = find_random_point(x1, y1, x2, y2)\nprint(f"Random point along the line: ({x3}, {y3})")