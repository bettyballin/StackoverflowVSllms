def remove_duplicates(L):\n    seen = set()\n    result = []\n    for sublist in L:\n        if sublist[0] not in seen:\n            seen.add(sublist[0])\n            result.append(sublist)\n    return result\n\nL = [['14', '65', 76], ['2', '5', 6], ['7', '12', 33], ['14', '22', 46]]\nL = remove_duplicates(L)\nprint(L)