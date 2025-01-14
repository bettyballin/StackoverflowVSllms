def split_list(lst, seg_length):\n    return [lst[i:i + seg_length] for i in range(0, len(lst), seg_length)]\n\n# Example usage\nalist = list(range(10))\nprint(split_list(alist, 3))