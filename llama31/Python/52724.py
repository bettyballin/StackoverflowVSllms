import math\n\ndef softplus(x):\n    return math.log(1 + math.exp(x)) + 1 - math.log(2)