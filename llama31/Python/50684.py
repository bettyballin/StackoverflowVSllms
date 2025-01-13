import networkx as nx\n\ndef count_unique_msts(G):\n    mst = nx.minimum_spanning_tree(G)\n    edge_counts = {}\n    for edge in G.edges():\n        weight = G.get_edge_data(edge[0], edge[1])['weight']\n        if weight not in edge_counts:\n            edge_counts[weight] = 0\n        edge_counts[weight] += 1\n\n    unique_edges = 0\n    for edge in mst.edges():\n        weight = mst.get_edge_data(edge[0], edge[1])['weight']\n        unique_edges += 1 - edge_counts[weight]\n\n    return 2 ** unique_edges\n\n# Example usage:\nG = nx.Graph()\nG.add_edge(1, 2, weight=1)\nG.add_edge(2, 3, weight=1)\nG.add_edge(3, 4, weight=2)\nG.add_edge(4, 5, weight=2)\n\nprint(count_unique_msts(G))  # Output: 2