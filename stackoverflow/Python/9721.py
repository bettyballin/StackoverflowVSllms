>>> f = open("csv.txt")\n>>> c = csv.reader(f)\n>>> for row in c: print row\n['1', '2', '3']\n['4', '5', '6']\n>>> f.seek(0)\n>>> for row in c: print row   # again\n['1', '2', '3']\n['4', '5', '6']