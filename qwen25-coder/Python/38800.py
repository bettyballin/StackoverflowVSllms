import random\n\ndef generate_permutations(x, y, z):\n    if y * z < x:\n        raise ValueError("Not enough slots to accommodate all unique elements at least once.")\n    \n    # Initialize all combinations of size z from 0 to x-1\n    all_combinations = [list(range(z*i, z*(i+1))) for i in range(x // z)]\n    if x % z != 0:\n        all_combinations.append(list(range((x//z) * z, x)))\n    \n    # Flatten and shuffle the initial distribution to ensure randomness\n    pool = [item for sublist in all_combinations for item in sublist]\n    random.shuffle(pool)\n    \n    # Repeat the pool elements to fill y lists\n    repeated_pool = (pool * (y // len(pool) + 1))[:y*z]\n    \n    # Distribute elements into y lists of z\n    result = []\n    index = 0\n    for _ in range(y):\n        while True:\n            sublist = repeated_pool[index:index+z]\n            if len(set(sublist)) == len(sublist):  # Ensure unique elements in each sublist\n                break\n            random.shuffle(repeated_pool)\n            index = 0\n        result.append(sublist)\n        index += z\n    \n    return result\n\n# Example usage:\nx = 4  # Elements 0 through x-1\ny = 7  # Number of lists\nz = 2  # Number of elements per list\n\npermutations = generate_permutations(x, y, z)\nfor p in permutations:\n    print(p)