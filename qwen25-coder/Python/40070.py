from decimal import Decimal, getcontext\n\n# Set the precision you need (e.g., 50 digits)\ngetcontext().prec = 50\n\ndef square(x):\n    return x * x\n\na = Decimal(1)\nb = Decimal(1) / Decimal(2).sqrt()\nt = Decimal(1) / Decimal(4)\np = Decimal(1)\n\nfor _ in range(int(getcontext().prec)):\n    y = a\n    a = (a + b) / Decimal(2)\n    b = (y * b).sqrt()\n    t -= p * square(y - a)\n    p *= 2\n\npi = (a + b) ** 2 / (Decimal(4) * t)\nprint(pi)