# util/math_operations.py\ndef add(a, b):\n    return a + b\n\ndef subtract(a, b):\n    return a - b\n\n# util/string_utils.py\ndef reverse_string(s):\n    return s[::-1]\n\n# package/calculator/__init__.py (empty file to denote a package)\n# package/calculator/basic_calculator.py\nfrom ..util.math_operations import add, subtract\n\nclass BasicCalculator:\n    def __init__(self):\n        pass\n    \n    def compute(self, operation, a, b):\n        if operation == 'add':\n            return add(a, b)\n        elif operation == 'subtract':\n            return subtract(a, b)\n\n# main.py\nfrom package.calculator.basic_calculator import BasicCalculator\n\ncalc = BasicCalculator()\nresult_add = calc.compute('add', 5, 3)\nresult_subtract = calc.compute('subtract', 10, 4)\n\nprint(f"Addition Result: {result_add}")\nprint(f"Subtraction Result: {result_subtract}")