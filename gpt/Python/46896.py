mytuple = (\n    ["tomato", 3],\n    ["say", 2],\n    ["say", 5],\n    ["I", 4],\n    ["you", 1],\n    ["tomato", 6],\n)\n\n# Sorting the tuple\nsorted_tuple = tuple(sorted(mytuple, key=lambda x: (x[0], x[1])))\n\nprint(sorted_tuple)