import itertools\nnested_list = [[1, 2, 3], [4, 5, 6], [7], [8, 9]]\nflattened_list = list(itertools.chain(*nested_list))\nprint(flattened_list)  # Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]