def first_unique_index(strings):\n    if not strings:\n        return 0\n    \n    min_length = min(len(s) for s in strings)\n    \n    for i in range(min_length):\n        char_count = {}\n        for string in strings:\n            char = string[i]\n            if char in char_count:\n                char_count[char] += 1\n            else:\n                char_count[char] = 1\n        \n        # Check if all characters at this index are unique\n        if all(count == 1 for count in char_count.values()):\n            return i\n    \n    return min_length\n\n# Example usage:\nstrings = ["apple", "banana", "cucumber", "banking"]\nprint(first_unique_index(strings))  # Output: 3