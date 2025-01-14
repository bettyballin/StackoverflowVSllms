import timeit\n\n# Measure instantiation time\ntuple_time = timeit.timeit(stmt="(1, 2, 3)", number=1000000)\nlist_time = timeit.timeit(stmt="[1, 2, 3]", number=1000000)\n\nprint(f"Tuple instantiation time: {tuple_time}")\nprint(f"List instantiation time: {list_time}")\n\n# Measure element access time\nelement_access_tuple = timeit.timeit(\n    stmt="t[0]",\n    setup="t = (1, 2, 3)",\n    number=1000000\n)\nelement_access_list = timeit.timeit(\n    stmt="l[0]",\n    setup="l = [1, 2, 3]",\n    number=1000000\n)\n\nprint(f"Tuple element access time: {element_access_tuple}")\nprint(f"List element access time: {element_access_list}")