def iterate(i):\n    has_yielded = False\n    for value in i:\n        has_yielded = True\n        yield value\n    if not has_yielded:\n        print('i is empty')\n\n# Example usage:\ngen = iterate([])\nfor item in gen:\n    print(item)