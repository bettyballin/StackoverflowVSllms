mytuple = (\n    ["tomato", 3],\n    ["say", 2],\n    ["say", 5],\n    ["I", 4],\n    ["you", 1],\n    ["tomato", 6],\n)\n\n# Sort by the first element of the inner lists\nsorted_mytuple = tuple(sorted(mytuple, key=lambda x: x[0]))\nprint(sorted_mytuple)\n\n# Sort by the second element of the inner lists\nsorted_mytuple = tuple(sorted(mytuple, key=lambda x: x[1]))\nprint(sorted_mytuple)