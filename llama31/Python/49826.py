def find_greatest(a, b, c, d):\n    greatest = a\n    if b > greatest:\n        greatest = b\n    if c > greatest:\n        greatest = c\n    if d > greatest:\n        greatest = d\n    return greatest\n\n# Example usage:\nnumbers = [12, 45, 7, 23]\ngreatest = find_greatest(*numbers)\nprint("The greatest number is:", greatest)