def permutations(arr):\n    if len(arr) == 1:\n        return [arr]\n    result = []\n    for i in range(len(arr)):\n        element = arr[i]\n        rest = arr[:i] + arr[i+1:]\n        for p in permutations(rest):\n            result.append([element] + p)\n    return result