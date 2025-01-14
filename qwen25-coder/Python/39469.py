function minSpanningArborescence(V, E, weights, root):\n    key = {v: ∞ for v in V}  // Key values used to pick minimum weight edge\n    parent = {v: null for v in V}\n    included = {v: false for v in V}\n\n    key[root] = 0\n\n    while there exists a vertex u not in included:\n        u = extractMinKeyVertex(key, included)\n        included[u] = true\n\n        for each edge (u, v) in E with weight w:\n            if not included[v] and u != root and w < key[v]:\n                if no directed path from v to u exists:\n                    parent[v] = u\n                    key[v] = w\n                else:  // We found a cycle!\n                    handleCycle(u, v)\n\n    return constructGraphFromParentMap(parent)\n\nfunction extractMinKeyVertex(key, included):\n    minIndex = None\n    for v in V:\n        if not included[v]:\n            if minIndex is None or key[v] < key[minIndex]:\n                minIndex = v\n    return minIndex\n\nfunction handleCycle(u, v):\n    # Detect and break cycle by removing edges selectively.\n    pass\n\nfunction constructGraphFromParentMap(parent):\n    edgesInMST = []\n    for v in V:\n        if parent[v] != null:\n            edgesInMST.append((parent[v], v))\n    return createGraphFromEdges(edgesInMST)