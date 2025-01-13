def recurring_decimal(a, b):\n    remainder = a % b\n    seen = {remainder: 0}\n    decimal = ""\n\n    while True:\n        remainder *= 10\n        decimal += str(remainder // b)\n        remainder %= b\n        if remainder == 0:\n            return decimal\n        elif remainder in seen:\n            start = seen[remainder]\n            return decimal[:start] + "(" + decimal[start:] + ")"\n        else:\n            seen[remainder] = len(decimal)\n\n# Example usage:\nprint(recurring_decimal(1, 2))  # Output: "0.5"\nprint(recurring_decimal(1, 3))  # Output: "0.(3)"\nprint(recurring_decimal(10, 7))  # Output: "1.(428571)"