def magic(num):\n    return [int(digit) for digit in str(num)]\n\n# Example usage:\nnum = 123\nlst = magic(num)\nprint(lst, type(lst))