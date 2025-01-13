def dfs(graph, visited, node):\n    if node not in visited:\n        visited.add(node)\n        for neighbor in graph.get(node, []):\n            dfs(graph, visited, neighbor)\n\ndef find_lit_nodes(graph, sources):\n    lit_nodes = set()\n    for source in sources:\n        dfs(graph, lit_nodes, source)\n    return lit_nodes\n\ndef remove_edge(graph, edge):\n    u, v = edge\n    if u in graph and v in graph[u]:\n        graph[u].remove(v)\n\ndef edge_removal_problem(graph, sources, edge):\n    # Find initially lit nodes\n    initially_lit = find_lit_nodes(graph, sources)\n    \n    # Remove the edge\n    remove_edge(graph, edge)\n    \n    # Find lit nodes after removing the edge\n    after_removal_lit = find_lit_nodes(graph, sources)\n    \n    # Determine nodes that were lit but are not anymore\n    no_longer_lit = initially_lit - after_removal_lit\n    \n    return no_longer_lit\n\n# Example usage\ngraph = {\n    1: [2, 3],\n    2: [4],\n    3: [4, 5],\n    4: [6],\n    5: [],\n    6: []\n}\nsources = [1]\nedge = (3, 4)\n\nnodes_no_longer_lit = edge_removal_problem(graph, sources, edge)\nprint("Nodes no longer lit:", nodes_no_longer_lit)