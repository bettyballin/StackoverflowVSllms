def aks_primality_test(n):\n    if n < 2:\n        return False\n    if n == 2 or n == 3:\n        return True\n    if n % 2 == 0:\n        return False\n\n    # Step 1: Find the smallest r such that ord_r(n) > log^2(n)\n    r = 2\n    while True:\n        if gcd(r, n) != 1:\n            return False\n        if is_composite(n, r):\n            return False\n        if is_primitive_root(n, r):\n            break\n        r += 1\n\n    # Step 2: Check if n is a power of a prime\n    for a in range(2, int(log(n, 2)) + 1):\n        if is_power_of_prime(n, a):\n            return False\n\n    # Step 3: Check if n is a witness for compositeness\n    for a in range(2, int(sqrt(r)) + 1):\n        if is_witness(n, a, r):\n            return False\n\n    return True\n\n\ndef gcd(a, b):\n    while b:\n        a, b = b, a % b\n    return a\n\n\ndef is_composite(n, r):\n    for a in range(2, int(sqrt(r)) + 1):\n        if pow(a, n, n) != a:\n            return True\n    return False\n\n\ndef is_primitive_root(n, r):\n    for a in range(2, int(sqrt(r)) + 1):\n        if pow(a, r, n) == 1:\n            return False\n    return True\n\n\ndef is_power_of_prime(n, a):\n    if n % a != 0:\n        return False\n    while n % a == 0:\n        n //= a\n    return n == 1\n\n\ndef is_witness(n, a, r):\n    x = pow(a, n, n)\n    if x == 1 or x == n - 1:\n        return False\n    for _ in range(r - 1):\n        x = pow(x, 2, n)\n        if x == n - 1:\n            return False\n    return True\n\n\nimport math\n\ndef sqrt(x):\n    return math.isqrt(x)\n\n\ndef log(x, base):\n    return math.log(x, base)