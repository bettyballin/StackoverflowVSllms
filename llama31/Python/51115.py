def swap_pairs(s):\n    if len(s) < 2:\n        return [s]\n\n    result = []\n    for i in range(len(s) - 1):\n        swapped = list(s)\n        swapped[i], swapped[i + 1] = swapped[i + 1], swapped[i]\n        result.append(''.join(swapped))\n\n    return result\n\nprint(swap_pairs('abcd'))