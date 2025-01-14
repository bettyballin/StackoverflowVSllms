from sympy import symbols, Function, summation\n\nn = symbols('n', integer=True)\n# Define the sequence\nseq = [1, 3, 6, 10, 15]\n\n# Guessing the closed form based on differences\n# The sequence represents triangular numbers\nclosed_form = n * (n + 1) / 2\n\nprint("Closed form function:", closed_form)