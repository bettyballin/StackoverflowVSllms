def build_index(some_list):\n    return {item[1]: idx for idx, item in enumerate(some_list)}\n\n# Example usage:\nl = [('a', 'b', 'c'), ('x', 'c', 'b'), ('z', 'c', 'b'), ('z', 'c', 'd'), ('a', 'd', 'd'), ('x', 'd', 'c')]\nindex_dict = build_index(l)\nprint(index_dict)