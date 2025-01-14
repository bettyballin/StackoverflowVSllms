def find_factors(n, domain_size, max_num):\n    """\n    Finds all ways to multiply numbers (1 to max_num) in domain_size parts to get n.\n    :param n: The target product.\n    :param domain_size: The number of factors to use.\n    :param max_num: The maximum number that can be used as a factor.\n    :return: A list of tuples, each containing a combination of factors.\n    """\n    def backtrack(remaining_product, current_combination, start):\n        # Base case: if the domain size is exceeded or remaining product is less than 1\n        if remaining_product < 1 or len(current_combination) > domain_size:\n            return []\n        \n        # If we've found a valid combination and it's the right size\n        if remaining_product == 1 and len(current_combination) == domain_size:\n            return [tuple(sorted(current_combination))]\n        \n        results = []\n        for i in range(start, max_num + 1):\n            if i > remaining_product:\n                break\n            # Recurse with updated product and combination\n            current_combination.append(i)\n            results.extend(backtrack(remaining_product // i, current_combination, i))\n            current_combination.pop()\n        \n        return results\n    \n    return backtrack(n, [], 1)\n\n# Example usage\npuzzle_size = 4  # 4x4 KenKen puzzle\ntarget_product = 24\ndomain_cells = 3\ncombinations = find_factors(target_product, domain_cells, puzzle_size)\nprint(combinations)