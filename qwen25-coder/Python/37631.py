def DFS_iterative(graph, start):\n    stack = [start]  # Initialize stack with the starting node\n    visited = set()\n    \n    while stack:\n        vertex = stack.pop()  # Pop a vertex from the stack\n        if vertex not in visited:\n            visited.add(vertex)\n            print(vertex)  # Process the vertex (e.g., print it)\n            for neighbor in graph[vertex]:  # Push all unvisited neighbors to the stack\n                if neighbor not in visited:\n                    stack.append(neighbor)