import random\n\ndef shuffle_array(arr):\n    # Implementing Fisher-Yates shuffle\n    n = len(arr)\n    for i in range(n-1, 0, -1):\n        j = random.randint(0, i)\n        arr[i], arr[j] = arr[j], arr[i]\n    return arr\n\n# Function to test randomness of shuffle_array\ndef test_randomness(test_func, array, num_tests=100000):\n    from collections import defaultdict\n    \n    n = len(array)\n    factorial_n = math.factorial(n)  # Number of permutations\n    permutation_count = defaultdict(int)\n\n    for _ in range(num_tests):\n        permuted_array = test_func(list(array))\n        permutation_str = tuple(permuted_array)\n        permutation_count[permutation_str] += 1\n\n    expected_frequency = num_tests / factorial_n\n    print(f"Expected frequency per permutation: {expected_frequency}")\n\n    chi_square_statistic = 0.0\n    for count in permutation_count.values():\n        chi_square_statistic += (count - expected_frequency) ** 2 / expected_frequency\n    \n    # Using a simple approximation for degrees of freedom for Chi-Square\n    dof = factorial_n - 1\n    from scipy.stats import chi2\n    p_value = 1 - chi2.cdf(chi_square_statistic, dof)\n    \n    print(f"Chi-squared test: {chi_square_statistic}, with p-value: {p_value}")\n    # A p-value > 0.05 typically indicates the shuffling is random\n    return p_value\n\nimport math\n\n# Example usage with a small array [1, 2]\narray = [1, 2]\np_value = test_randomness(shuffle_array, array)\nprint("The shuffle function appears to be random." if p_value > 0.05 else "The shuffle function does not appear to be random.")