def compute_totients(limit):\n    phi = list(range(limit + 1))\n    for i in range(2, limit + 1):\n        if phi[i] == i:  # i is a prime\n            for j in range(i, limit + 1, i):\n                phi[j] *= (i - 1)\n                phi[j] //= i\n    return phi\n\ndef chain_length(n, phi):\n    length = 1\n    while n != 1:\n        n = phi[n]\n        length += 1\n    return length\n\ndef sum_primes_with_chain_length(limit, target_chain_length):\n    phi = compute_totients(limit)\n    is_prime = [True] * (limit + 1)\n    is_prime[0] = is_prime[1] = False\n    p = 2\n    while p * p <= limit:\n        if is_prime[p]:\n            for i in range(p * p, limit + 1, p):\n                is_prime[i] = False\n        p += 1\n\n    total_sum = 0\n    for p in range(2, limit):\n        if is_prime[p] and chain_length(p, phi) == target_chain_length:\n            total_sum += p\n    \n    return total_sum\n\nlimit = 40000000\ntarget_chain_length = 25\nresult = sum_primes_with_chain_length(limit, target_chain_length)\nprint(result)