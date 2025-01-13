def reverse_list(lst):\n    # Base case: if the list is empty, return an empty list\n    if not lst:\n        return []\n    # Recursive case: return the last element concatenated with the reversed remainder of the list\n    return [lst[-1]] + reverse_list(lst[:-1])\n\n# Example usage\noriginal_list = [1, 2, 3, 4, 5]\nreversed_list = reverse_list(original_list)\nprint(reversed_list)  # Output: [5, 4, 3, 2, 1]