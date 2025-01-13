#A tree is a tuple of an int and a tree. \nt = (1, (2,(4, (6), (7, (9)) )), (3, (5, (8)) ))\ndef bfs(t):\n    to_visit = [t]\n    while len(to_visit) > 0:\n        c = to_visit[0]\n        if type(c) is int:\n            print c\n        else: \n            print c[0]\n            to_visit.append(c[1])\n            if len(c) > 2: to_visit.append(c[2])\n        to_visit = to_visit[1:]\n\ndef dfs(t):\n    if type(t) is int:\n        print t\n        return \n    print t[0]\n    dfs(t[1])\n    if len(t) > 2: dfs(t[2]) \n\nbfs(t)\ndfs(t)