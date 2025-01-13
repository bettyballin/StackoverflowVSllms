import networkx as nx\n\ndef hopcroft_karp(graph):\n    matching = {}\n    augmenting_paths = []\n\n    while True:\n        augmenting_paths = []\n        for u in graph.nodes():\n            if u not in matching:\n                for v in graph.neighbors(u):\n                    if v not in matching.values():\n                        augmenting_paths.append((u, v))\n\n        if not augmenting_paths:\n            break\n\n        for u, v in augmenting_paths:\n            matching[u] = v\n\n    return matching\n\n# Create a bipartite graph with machines and jobs\nG = nx.Graph()\nG.add_nodes_from([f"Machine {i}" for i in range(m)], bipartite=0)\nG.add_nodes_from([f"Job {j}" for j in range(j)], bipartite=1)\n\n# Add edges between machines and jobs\nfor i in range(m):\n    for j in range(j):\n        if i <= j:  # Each job can only be assigned to machines i through j\n            G.add_edge(f"Machine {i}", f"Job {j}")\n\n# Run the Hopcroft-Karp algorithm\nmatching = hopcroft_karp(G)\n\n# Print the assignment\nfor machine, job in matching.items():\n    print(f"{machine} -> {job}")