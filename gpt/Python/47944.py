def nested_sum(lst):\n    """Recursively computes the sum of all numbers in a nested list."""\n    if isinstance(lst, int):\n        return lst\n    elif isinstance(lst, list):\n        return sum(nested_sum(item) for item in lst)\n    return 0\n\ndef sort_nested_lists(lst):\n    """Sorts a list of nested lists based on the sum of their elements."""\n    return sorted(lst, key=nested_sum)\n\n# Example usage\nl = [[[[[39]]]], [1, 2, 3], [4, [5, 3], 1], [[[[8, 9], 10], 11], 12]]\nsorted_list = sort_nested_lists(l)\nprint(sorted_list)