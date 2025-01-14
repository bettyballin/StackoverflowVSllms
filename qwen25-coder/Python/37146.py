from itertools import combinations\n\nitems = {\n    'socks': 4.00,\n    'cheap tv': 22.00,\n    'book on tape': 9.00,\n    'book on paper': 7.00,\n    'party hats': 3.00,\n    'picture frame': 10.00,\n    'hammer': 5.00,\n    'juicer': 16.00,\n    'mysql guide': 24.00\n}\ntarget = 70  # total price - desired return (100 - 30)\n\nfor r in range(1, len(items) + 1):\n    for combo in combinations(items, r):\n        if sum(items[item] for item in combo) == target:\n            print(combo)