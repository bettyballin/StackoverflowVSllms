def reverse_slice(lst, start):\n    # Ensure the start is within bounds\n    if start >= len(lst):\n        return []\n    # Slice from start to the beginning with a negative stride\n    return lst[start::-1]\n\nA = list(range(10))\nresult = reverse_slice(A, 4)\nprint(result)  # Output: [4, 3, 2, 1, 0]