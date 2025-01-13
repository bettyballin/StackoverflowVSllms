import itertools\n\ndef generate_factors(factorization):\n    primes = list(factorization.keys())\n    exponents = [range(exp + 1) for exp in factorization.values()]\n    for exp_combination in itertools.product(*exponents):\n        factor = 1\n        for prime, exp in zip(primes, exp_combination):\n            factor *= prime ** exp\n        yield factor\n\n# Example usage:\nfactorization = {2: 3, 3: 2, 5: 1}\nfor factor in generate_factors(factorization):\n    print(factor)