def bfs(graph, start_node):\n    visited = set()\n    queue = [start_node]\n\n    while queue:\n        node = queue.pop(0)\n        if node not in visited:\n            visited.add(node)\n            print(node)\n            for neighbor in graph[node]:\n                if neighbor not in visited:\n                    queue.append(neighbor)\n\n# Example usage:\ngraph = {\n    'A': ['B', 'C'],\n    'B': ['A', 'D', 'E'],\n    'C': ['A', 'F'],\n    'D': ['B'],\n    'E': ['B', 'F'],\n    'F': ['C', 'E']\n}\n\nbfs(graph, 'A')  # Output: A, B, C, D, E, F