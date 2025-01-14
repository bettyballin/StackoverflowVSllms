import random\n\ndef fisher_yates_shuffle(data):\n    """\n    Shuffle the list 'data' in place using the Fisher-Yates algorithm.\n    \n    Args:\n    data (list): The list of data points to shuffle.\n    \n    Returns:\n    list: The shuffled list of data points.\n    """\n    n = len(data)\n    for i in range(n-1, 0, -1):\n        j = random.randint(0, i)\n        data[i], data[j] = data[j], data[i]\n    return data\n\n# Example data\ndata = [0.1, 0.2, 0.4, 0.5, 0.6, 0.8, 0.4, 0.5, 0.2, 0.2, 0.3, 0.5]\n\n# Shuffle the data\nshuffled_data = fisher_yates_shuffle(data.copy())\n\n# Assign the shuffled data to groups with the same sizes as the original groups\ngroup_sizes = {'A': 3, 'B': 3, 'C': 2, 'D': 4}\n\ngroups = {}\nindex = 0\nfor group, size in group_sizes.items():\n    groups[group] = shuffled_data[index:index + size]\n    index += size\n\nprint(groups)