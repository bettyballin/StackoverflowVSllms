def dfs(graph, start, visited):\n    stack = [start]\n    while stack:\n        v = stack.pop()\n        if not visited[v]:\n            visited[v] = True\n            for neighbor in graph[v]:\n                stack.append(neighbor)\n\ndef find_lit_nodes(graph, sources):\n    visited = {node: False for node in graph}\n    for source in sources:\n        dfs(graph, source, visited)\n    return {node for node, is_visited in visited.items() if is_visited}\n\ndef edge_removal_effect(graph, sources, u, v):\n    # Original set of lit nodes\n    originally_lit = find_lit_nodes(graph, sources)\n    \n    # Remove the edge (u, v)\n    graph[u] = [w for w in graph[u] if w != v]\n    \n    # New set of lit nodes after removal\n    new_lit = find_lit_nodes(graph, sources)\n    \n    # Nodes that were previously lit but are not lit anymore\n    affected_nodes = originally_lit - new_lit\n    \n    return affected_nodes\n\n# Example usage:\ngraph = {\n    0: [1, 2],\n    1: [3],\n    2: [],\n    3: []\n}\nsources = [0]\nu, v = 0, 1  # Edge to remove\n\naffected = edge_removal_effect(graph, sources, u, v)\nprint("Nodes that are no longer lit:", affected)