original = [('a', 1), ('b', 2), ('c', 3), ('d', 4)]\nx, y = zip(*original)\nresult = (list(x), list(y))