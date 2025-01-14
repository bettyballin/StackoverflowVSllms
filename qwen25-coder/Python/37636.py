def BFS(graph, start):\n    visited = set()\n    queue = [start]  # Initialize queue with the starting node\n    \n    while queue:\n        vertex = queue.pop(0)  # Dequeue a vertex from the queue\n        if vertex not in visited:\n            visited.add(vertex)\n            print(vertex)  # Process the vertex (e.g., print it)\n            for neighbor in graph[vertex]:  # Enqueue all unvisited neighbors\n                if neighbor not in visited:\n                    queue.append(neighbor)