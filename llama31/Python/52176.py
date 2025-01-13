import unittest\nfrom plc_simulator import PlcSimulator\n\nclass TestPlcSystem(unittest.TestCase):\n    def setUp(self):\n        self.simulator = PlcSimulator()\n\n    def test_simple_case(self):\n        # Set input A to ON\n        self.simulator.set_input('A', True)\n        # Verify output B is ON\n        self.assertTrue(self.simulator.get_output('B'))\n\n    def test_more_complex_case(self):\n        # Set inputs A and C to ON\n        self.simulator.set_input('A', True)\n        self.simulator.set_input('C', True)\n        # Verify output D is ON after 5 seconds\n        self.simulator.run_for(5)\n        self.assertTrue(self.simulator.get_output('D'))\n\nif __name__ == '__main__':\n    unittest.main()