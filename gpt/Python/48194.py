list1 = [2, 2, 2]\nlist2 = [1, 1, 1]\n\nresult = [a - b for a, b in zip(list1, list2)]\nprint(result)  # Output: [1, 1, 1]