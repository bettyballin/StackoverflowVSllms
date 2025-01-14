import itertools\n\ndef cartesian_product(lists):\n    return [combo for combo in itertools.product(*lists)]\n\n# Example usage:\nsets = [[1, 2], ['a', 'b'], [True, False]]\nresult = cartesian_product(sets)\nprint(result)