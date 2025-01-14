import itertools\n\n# Define sets of test cases: normal values, edge cases, fringe cases\nnormal_values = {5, 10}\nedge_values = {0, -1}\nfringe_cases = {float('inf'), 1000}\n\n# Combine all into one set for simplicity\ntest_values = normal_values.union(edge_values).union(fringe_cases)\n\n# Generate all possible combinations of length 3 (for triangle lengths)\ncombinations_with_replacement = itertools.combinations_with_replacement(test_values, 3)\npermutations_of_combinations = set(itertools.chain.from_iterable(\n    itertools.permutations(combination) for combination in combinations_with_replacement\n))\n\n# Example output: first few test cases\ntest_cases = list(permutations_of_combinations)[:10]\nprint(test_cases)