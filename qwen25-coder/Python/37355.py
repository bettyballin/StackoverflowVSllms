from collections import Counter\n\n# Original list\nlst = [0, 1, 1, 2, 2]\n\n# Count occurrences of each element\ncounts = Counter(lst)\n\n# Filter list to include only elements that occur once\nresult = [element for element in lst if counts[element] == 1]\n\nprint(result)  # Output: [0]