import math\n\ndef calculate_entropy(data):\n    frequencies = {}\n    for byte in data:\n        frequencies[byte] = frequencies.get(byte, 0) + 1\n    entropy = 0.0\n    for freq in frequencies.values():\n        p_x = freq / len(data)\n        entropy += - p_x * math.log(p_x, 2)\n    return entropy