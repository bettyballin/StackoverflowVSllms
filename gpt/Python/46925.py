import networkx as nx\n\n    G = nx.DiGraph()\n    G.add_edges_from([(1, 2), (1, 3), (2, 4), (3, 5)])\n\n    # Traversal example\n    for node in nx.dfs_preorder_nodes(G, source=1):\n        print(node)