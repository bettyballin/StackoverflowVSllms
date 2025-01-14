def sieve_of_eratosthenes(limit):\n    is_prime = [True] * limit\n    p = 2\n    while (p * p < limit):\n        if (is_prime[p] == True):\n            for i in range(p * p, limit, p):\n                is_prime[i] = False\n        p += 1\n\n    prime_numbers = []\n    for p in range(2, limit):\n        if is_prime[p]:\n            prime_numbers.append(p)\n    return prime_numbers\n\ndef first_n_primes(n):\n    # Approximate upper bound for nth prime using n * (log(n) + log(log(n)))\n    import math\n    if n < 6:\n        limit = 15\n    else:\n        limit = int(n * (math.log(n) + math.log(math.log(n))))\n    \n    primes = sieve_of_eratosthenes(limit)\n    return primes[:n]\n\n# Print the first 10,000 prime numbers\nprimes = first_n_primes(10000)\nfor prime in primes:\n    print(prime)