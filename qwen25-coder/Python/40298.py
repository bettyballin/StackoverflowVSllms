import itertools\n\nsomelists = [\n   [1, 2, 3],\n   ['a', 'b'],\n   [4, 5]\n]\n\n# Use * to unpack the list of lists\ncartesian_product = list(itertools.product(*somelists))\n\nprint(cartesian_product)