a = {1: '', 2: '', 3: '', 4: ''}\nexclusion = [3, 4, 5]\n\na = {k: v for k, v in a.items() if k not in exclusion}