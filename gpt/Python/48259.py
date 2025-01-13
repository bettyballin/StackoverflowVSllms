def permute_in_place(arr, perm):\n    n = len(arr)\n    for i in range(n):\n        while perm[i] != i:\n            swap_idx = perm[i]\n            arr[i], arr[swap_idx] = arr[swap_idx], arr[i]\n            perm[i], perm[swap_idx] = perm[swap_idx], perm[i]\n\n# Example usage:\narr = [45, 89, 22, 31, 23, 76]\nperm = [5, 3, 2, 1, 0, 4]\npermute_in_place(arr, perm)\nprint(arr)  # Output: [76, 31, 22, 89, 45, 23]