def factorial(n): \n    if n < 2: return 1\n    return reduce(lambda x, y: x*y, xrange(2, int(n)+1))\n\ndef prob(s, p, n):\n    x = 1.0 - p\n\n    a = n - s\n    b = s + 1\n\n    c = a + b - 1\n\n    prob = 0.0\n\n    for j in xrange(a, c + 1):\n        prob += factorial(c) / (factorial(j)*factorial(c-j)) \\n                * x**j * (1 - x)**(c-j)\n\n    return prob\n\n>>> prob(20, 0.3, 100)\n0.016462853241869437\n\n>>> 1-prob(40-1, 0.3, 100)\n0.020988576003924564