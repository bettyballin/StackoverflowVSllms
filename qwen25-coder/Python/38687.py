x = [1, 2, 2, 2, 2]\n\nfor i in x[:]:  # Iterate over a slice (copy) of the list\n    if i == 2:  # Example condition to remove elements\n        x.remove(i)\n\nprint(x)