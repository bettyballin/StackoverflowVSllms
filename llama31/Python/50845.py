data.sort(key=lambda x: float(x[sortby]) if x[sortby].replace('.', '', 1).isdigit() else x[sortby])