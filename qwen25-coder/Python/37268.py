d1 = {0: ['11', '18', '25', '38'],\n      1: ['11', '18', '25', '38'],\n      2: ['11', '18', '25', '38'],\n      3: ['11', '18', '25', '38']}\n\nd2 = {0: ['05', '08', '11', '13', '16', '25', '34', '38', '40', '43'],\n      1: ['05', '08', '09', '13', '15', '20', '32', '36', '38', '40', '41'],\n      2: ['02', '08', '11', '13', '18', '20', '22', '33', '36', '39'],\n      3: ['06', '11', '12', '25', '26', '27', '28', '30', '31', '37']}\n\nd3 = {}\n\nfor key, value in d1.items():\n    # Convert lists to sets and find the intersection\n    common_elements = list(set(value).intersection(d2[key]))\n    d3[key] = common_elements\n\nprint(d3)