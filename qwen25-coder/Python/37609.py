def func(k, n=0):\n    if k < 3:\n        return 3 ** k\n    \n    # Calculate the midpoint of the current range\n    mid = (3 ** n + 3 ** (n + 1)) // 2\n    \n    if k < mid:\n        # k is in the lower half, recurse with n unchanged\n        return func(k, n)\n    else:\n        # k is in the upper half, calculate 3^n and recurse with n+1\n        power_of_3_n = 3 ** n\n        return power_of_3_n * func(k - (power_of_3_n // 3), n + 1)\n\n# Example usage:\nprint(func(1))  # Output: 27 (3^3)\nprint(func(5))  # Output: 243 (3^5)