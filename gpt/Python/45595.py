from collections import deque\n\ndef bfs_shortest_path(friendship_graph, start_user, target_user):\n    # Initialize the queue with the start user and the path taken to reach them\n    queue = deque([(start_user, [start_user])])\n    visited = set([start_user])\n    \n    while queue:\n        current_user, path = queue.popleft()\n        \n        # If we have found the target user, return the path and its length (degree of separation)\n        if current_user == target_user:\n            return path, len(path) - 1\n        \n        # Enqueue unvisited friends\n        for friend in friendship_graph.get(current_user, []):\n            if friend not in visited:\n                visited.add(friend)\n                queue.append((friend, path + [friend]))\n    \n    # If the target user is not reachable, return None\n    return None, -1\n\n# Example usage:\nfriendship_graph = {\n    'A': ['B', 'C'],\n    'B': ['A', 'D', 'E'],\n    'C': ['A', 'F'],\n    'D': ['B'],\n    'E': ['B', 'F'],\n    'F': ['C', 'E']\n}\n\nstart_user = 'A'\ntarget_user = 'F'\npath, degree = bfs_shortest_path(friendship_graph, start_user, target_user)\nprint(f"Path: {path}")\nprint(f"Degree of separation: {degree}")