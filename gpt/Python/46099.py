class Expr:\n    def __init__(self, left):\n        self.left = left\n\n    def __eq__(self, right):\n        return f"{self.left} == {right}"\n\ndef magic(expression):\n    print(expression)\n\n# Example usage\nexpr = Expr(5)\nmagic(expr == 5)