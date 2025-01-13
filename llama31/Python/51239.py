import networkx as nx\n\ndef partition_sets(sets):\n    G = nx.Graph()\n    for i, s in enumerate(sets):\n        G.add_node(i)\n        for j, t in enumerate(sets):\n            if i != j and not s.isdisjoint(t):\n                G.add_edge(i, j)\n\n    groups = []\n    for c in nx.connected_components(G):\n        groups.append([sets[i] for i in c])\n\n    return groups\n\nsets = [(1, 2, 3), (5, 2, 6), (7, 8, 9), (6, 12, 13), (21, 8, 34), (19, 20)]\nprint(partition_sets(sets))