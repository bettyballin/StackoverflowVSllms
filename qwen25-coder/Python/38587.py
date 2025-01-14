def gcd(a, b):\n    """Compute the Greatest Common Divisor using the Euclidean algorithm."""\n    while b:\n        a, b = b, a % b\n    return a\n\ndef lcm(a, b):\n    """Compute the Least Common Multiple using the relationship between GCD and LCM."""\n    return abs(a * b) // gcd(a, b)\n\ndef lcm_of_list(numbers):\n    """Find the LCM of a list of numbers."""\n    current_lcm = 1\n    for number in numbers:\n        current_lcm = lcm(current_lcm, number)\n    return current_lcm\n\n# Example usage for numbers from 1 to 20\nnumbers = range(1, 21)\nresult = lcm_of_list(numbers)\nprint(f"The smallest number divisible by all numbers from 1 to 20 is: {result}")