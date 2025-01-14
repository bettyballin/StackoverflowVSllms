def factorial(x):\n    if x == 0:\n        return 1\n    else:\n        return x * factorial(x-1)\n\ndef sin_taylor_series(x, terms=10):\n    result = 0.0\n    for n in range(terms):\n        result += ((-1)**n) * (x**(2*n + 1)) / factorial(2*n + 1)\n    return result\n\n# Example usage:\nangle_in_radians = 1.0  # 1 radian is approximately 57.3 degrees\nprint(sin_taylor_series(angle_in_radians))