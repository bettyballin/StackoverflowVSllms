from functools import reduce\n\nfactorial_one_liner = lambda n: reduce(lambda x, y: x * y, range(1, n + 1), 1)