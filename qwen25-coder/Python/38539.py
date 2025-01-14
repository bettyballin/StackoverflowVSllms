def extract(data_dict, target_globals=None):\n    if target_globals is None:\n        # This will only work outside of functions\n        target_globals = globals()\n    target_globals.update(data_dict)\n\n# Example usage\nfoo = 'what'\nbar = 'ever'\na = {'foo': 'new_value', 'baz': 'another'}\nextract(a)\nprint(foo)  # Output: new_value\nprint(baz)  # Output: another