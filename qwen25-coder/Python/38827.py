import itertools\n\ndef generate_factors(prime_factors):\n    # Create lists of powers for each prime factor\n    power_lists = [[prime ** exp for exp in range(exp + 1)] \n                   for prime, exp in prime_factors.items()]\n    \n    # Use itertools.product to iterate over all combinations of these powers\n    factors = set()\n    for combo in itertools.product(*power_lists):\n        factor = 1\n        for num in combo:\n            factor *= num\n        factors.add(factor)\n    \n    return sorted(factors)\n\n# Example usage\nprime_factors = {2: 3, 3: 2, 5: 1}\nfactors_of_number = generate_factors(prime_factors)\nprint(factors_of_number)