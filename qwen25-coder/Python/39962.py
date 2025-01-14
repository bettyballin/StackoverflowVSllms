def find_subsets_with_sum(arr, X):\n    def backtrack(start, current_subset, current_sum):\n        if current_sum == X:\n            result.append(list(current_subset))\n            return\n        if current_sum > X or start >= len(arr):\n            return\n\n        # Include arr[start]\n        current_subset.append(arr[start])\n        backtrack(start + 1, current_subset, current_sum + arr[start])\n\n        # Exclude arr[start] and move to the next element\n        current_subset.pop()\n        backtrack(start + 1, current_subset, current_sum)\n\n    result = []\n    backtrack(0, [], 0)\n    return result\n\n# Example usage:\narr = [2, 3, 5, 7]\nX = 10\nsubsets = find_subsets_with_sum(arr, X)\nprint(subsets)  # Output: [[2, 3, 5], [3, 7]]