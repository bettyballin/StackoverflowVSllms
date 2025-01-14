import math\n\ndef closest_power_of_2(n):\n    if n == 0:\n        return 0\n    log2_n = math.log2(abs(n))\n    lower_pow = 2 ** math.floor(log2_n)\n    upper_pow = 2 ** math.ceil(log2_n)\n    return (upper_pow if abs(upper_pow - n) < abs(lower_pow - n) else lower_pow)\n\n# Example usage\nprint(closest_power_of_2(3.5))   # Output: 4\nprint(closest_power_of_2(123))   # Output: 128\nprint(closest_power_of_2(0.24))  # Output: 0.25