import doctest\nfrom unittest import TestCase\nfrom io import StringIO\n\nclass MyTest(TestCase):\n    def testIt(self):\n        # Simulate some output that uses stdout\n        output = "This is a line with an info message\nMore details..."\n        \n        # Capture the expected output as you would write in a docstring\n        expected_output = '''\\nThis is a line with an info message\nMore details...'''\n\n        # Use doctest.OutputChecker to compare the outputs\n        checker = doctest.OutputChecker()\n        match = checker.check_output(output, expected_output, 0)\n        \n        if not match:\n            diff = checker.output_difference(doctest.Example("", ""), output)\n            self.fail(f"Output does not match:\n{diff}")