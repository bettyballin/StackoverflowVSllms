a = [1, 2, 3, 4, 5]\n\n# Rotate left by one position\na = a[1:] + a[:1]\nprint(a)  # Output: [2, 3, 4, 5, 1]\n\n# Rotate again\na = a[1:] + a[:1]\nprint(a)  # Output: [3, 4, 5, 1, 2]