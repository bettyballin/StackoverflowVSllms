def sum_nested_list(lst):\n    """Recursively calculates the sum of all integers in a nested list."""\n    total = 0\n    for item in lst:\n        if isinstance(item, list):\n            total += sum_nested_list(item)\n        else:\n            total += item\n    return total\n\nl = [[[[[39]]]], [1, 2, 3], [4, [5, 3], 1], [[[[8, 9], 10], 11], 12]]\nsorted_list = sorted(l, key=sum_nested_list)\n\nprint(sorted_list)