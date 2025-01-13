import heapq\n\ndef max_min_path(graph, start, end):\n    # Priority queue to store the paths\n    pq = [(-float('inf'), start, [])]\n    # Set to store visited nodes\n    visited = set()\n\n    while pq:\n        # Get the path with the max minimal weight\n        min_weight, node, path = heapq.heappop(pq)\n        min_weight = -min_weight\n        path = path + [node]\n\n        # If the end node is reached, return the result\n        if node == end:\n            return (min_weight, path)\n\n        # Skip the visited nodes\n        if node in visited:\n            continue\n        visited.add(node)\n\n        # Explore neighbors\n        for neighbor, weight in graph[node]:\n            if neighbor not in visited:\n                new_min_weight = min(min_weight, weight)\n                heapq.heappush(pq, (-new_min_weight, neighbor, path))\n\n    return None\n\n# Example usage:\n# Graph represented as an adjacency list\ngraph = {\n    'A': [('B', 10), ('C', 2)],\n    'B': [('D', 1)],\n    'C': [('D', 2)],\n    'D': []\n}\n\nstart = 'A'\nend = 'D'\nresult = max_min_path(graph, start, end)\nprint("Maximum minimal weight:", result[0])\nprint("Path:", " -> ".join(result[1]))