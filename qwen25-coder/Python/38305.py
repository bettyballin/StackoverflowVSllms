original_2d_list = [\n    ["apple", "banana", "cherry"],\n    ["date", "fig", "grape"],\n    ["honeydew", "kiwi", "lemon"]\n]\n# Copy rows 1 to 2 and columns 0 to 1\nportion_of_2d_list = [row[0:2] for row in original_2d_list[1:3]]\nprint(portion_of_2d_list)  \n# Output: [['date', 'fig'], ['honeydew', 'kiwi']]