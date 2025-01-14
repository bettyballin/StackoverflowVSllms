from behave import given, when, then\nfrom unittest import TestCase\n\nclass TestAdditionFeature(TestCase):\n    def __init__(self, *args, **kwargs):\n        super().__init__(*args, **kwargs)\n        self.calculator = None\n        self.result = None\n\n    @given('I have a calculator')\n    def given_a_calculator(self):\n        self.calculator = lambda x, y: x + y\n\n    @when('I add {x} to {y}')\n    def when_add_x_and_y(self, x, y):\n        self.result = self.calculator(int(x), int(y))\n\n    @then('the result should be {result}')\n    def then_the_result_should_be(self, result):\n        self.assertEqual(self.result, int(result))\n\n# To run the test, use: behave -f plai