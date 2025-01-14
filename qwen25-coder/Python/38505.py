tuple_list = [("pineapple", 5), ("cherry", 7), ("kumquat", 3), ("plum", 11)]\n\ndef get_index_of_tuple(lst, sub_index, value):\n    return next((i for i, t in enumerate(lst) if t[sub_index] == value), None)\n\n# Example usage:\nindex = get_index_of_tuple(tuple_list, 0, "kumquat")  # Returns 2\nprint(index)\nindex = get_index_of_tuple(tuple_list, 1, 7)        # Returns 1\nprint(index)