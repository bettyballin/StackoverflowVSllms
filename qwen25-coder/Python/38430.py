myDict = {'item1': [7, 1, 9], 'item2': [8, 2, 3], 'item3': [9, 3, 11]}\n\n# Sort the dictionary based on the third element in each list\nsorted_dict = dict(sorted(myDict.items(), key=lambda item: item[1][2]))\n\n# Iterate through the sorted dictionary\nfor key, value in sorted_dict.items():\n    print(key, value)