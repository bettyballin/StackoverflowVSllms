>>> import math\n>>> def remove_most_significant_digit(n, base=10):\n...     return n % (base ** int(math.log(n, base)))\n...\n>>> def remove_least_significant_digit(n, base=10):\n...     return int(n // base)\n...\n>>> remove_most_significant_digit(12345)\n2345\n>>> remove_least_significant_digit(12345)\n1234