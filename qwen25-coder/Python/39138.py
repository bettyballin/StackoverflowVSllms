from collections import deque\n\ndef bfs_shortest_path(graph, start, goal):\n    # Queue for BFS: stores tuples of (node, path_length)\n    queue = deque([(start, 0)])\n    visited = set()  # To track visited nodes and avoid cycles\n\n    while queue:\n        current_node, path_length = queue.popleft()\n        \n        if current_node == goal:\n            return path_length\n        \n        if current_node not in visited:\n            visited.add(current_node)\n            \n            for neighbor in graph[current_node]:\n                if neighbor not in visited:\n                    queue.append((neighbor, path_length + 1))\n    \n    # If the goal is not reachable from start\n    return -1\n\n# Example usage:\n# Graph represented as an adjacency list\nsocial_network_graph = {\n    'alice': {'bob', 'dave'},\n    'bob': {'alice', 'charlie', 'dave'},\n    'charlie': {'bob', 'eve'},\n    'dave': {'alice', 'bob'},\n    'eve': {'charlie'}\n}\n\n# Calculate Kevin Bacon number between 'alice' and 'eve'\nkevin_bacon_number = bfs_shortest_path(social_network_graph, 'alice', 'eve')\nprint(f"Shortest path length (Kevin Bacon number) from alice to eve: {kevin_bacon_number}")