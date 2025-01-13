from collections import defaultdict, deque\n\ndef bfs_traversal(graph):\n    """\n    Performs a BFS traversal of the DAG and returns a topologically sorted list of nodes.\n    """\n    in_degree = defaultdict(int)\n    for node in graph:\n        for neighbor in graph[node]:\n            in_degree[neighbor] += 1\n\n    queue = deque([node for node in graph if in_degree[node] == 0])\n    sorted_nodes = []\n\n    while queue:\n        node = queue.popleft()\n        sorted_nodes.append(node)\n        for neighbor in graph[node]:\n            in_degree[neighbor] -= 1\n            if in_degree[neighbor] == 0:\n                queue.append(neighbor)\n\n    return sorted_nodes\n\n# Example usage:\ngraph = {\n    'A': ['B', 'C'],\n    'B': ['D'],\n    'C': ['D'],\n    'D': []\n}\n\nsorted_nodes = bfs_traversal(graph)\nprint(sorted_nodes)  # Output: ['A', 'B', 'C', 'D']