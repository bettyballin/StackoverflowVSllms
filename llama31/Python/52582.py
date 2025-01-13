import doctest\nfrom unittest import TestCase\nfrom io import StringIO\n\nclass MyTest(TestCase):\n    def testIt(self):\n        # some codes like self.assertEqual(...)\n        output = StringIO()\n        with StdoutCollector(output):\n            # do something that uses stdout\n        checker = doctest.OutputChecker()\n        expected_output = 'expected output'\n        self.assertTrue(checker.check_output(output.getvalue(), expected_output))\n        # do more things