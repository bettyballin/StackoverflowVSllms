array = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]\nresult = [sum(group) for group in zip(*array)]\nprint(result)  # Output: [12, 15, 18]