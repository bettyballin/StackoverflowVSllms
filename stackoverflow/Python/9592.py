def table(n):\n    if n == 2: return 1\n    if n%4 != 1: return\n\n    mod = 0\n    a1 = n - 1\n    for a in xrange(1, a1, 2):\n        mod += a\n\n        while mod >= n: mod -= n\n        if mod == a1: return a//2 + 1