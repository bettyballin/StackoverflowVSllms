>>> tuple_list = [("pineapple", 5), ("cherry", 7), ("kumquat", 3), ("plum", 11)]\n>>> [x for x, y in enumerate(tuple_list) if y[1] == 7]\n[1]\n>>> [x for x, y in enumerate(tuple_list) if y[0] == 'kumquat']\n[2]