def find_greatest_number(a, b, c, d):\n    greatest = a  # Assume a is the greatest initially\n    if b > greatest:\n        greatest = b\n    if c > greatest:\n        greatest = c\n    if d > greatest:\n        greatest = d\n    return greatest\n\n# Example usage:\nnum1, num2, num3, num4 = 10, 25, 15, 20\nprint("The greatest number is:", find_greatest_number(num1, num2, num3, num4))