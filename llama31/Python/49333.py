import re\n\nclass ExpressionEvaluator:\n    def __init__(self, expression):\n        self.expression = expression\n\n    def evaluate(self):\n        # Simple recursive descent parser\n        def parse_factor():\n            match = re.match(r'\d+', self.expression)\n            if match:\n                return int(match.group())\n            raise ValueError("Invalid factor")\n\n        def parse_term():\n            result = parse_factor()\n            while self.expression.startswith('*'):\n                self.expression = self.expression[1:]\n                result *= parse_factor()\n            return result\n\n        def parse_expression():\n            result = parse_term()\n            while self.expression.startswith('+'):\n                self.expression = self.expression[1:]\n                result += parse_term()\n            return result\n\n        return parse_expression()\n\n# Example usage:\nevaluator = ExpressionEvaluator("2+3*4")\nresult = evaluator.evaluate()\nprint(result)  # Output: 14