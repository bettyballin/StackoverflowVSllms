import heapq\n\ndef dijkstra(grid, start, goal):\n    # Directions for moving up, down, left, right\n    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]\n    \n    # Priority queue initialization\n    priority_queue = []\n    heapq.heappush(priority_queue, (0, start))\n    \n    # Dictionaries to store the cost and predecessor of each node\n    cost_so_far = {start: 0}\n    came_from = {start: None}\n    \n    while priority_queue:\n        current_cost, current_position = heapq.heappop(priority_queue)\n        \n        if current_position == goal:\n            break\n        \n        for dr, dc in directions:\n            neighbor = (current_position[0] + dr, current_position[1] + dc)\n            \n            # Assuming grid boundaries and wall check here\n            if 0 <= neighbor[0] < len(grid) and 0 <= neighbor[1] < len(grid[0]) and grid[neighbor[0]][neighbor[1]] != '#':\n                new_cost = cost_so_far[current_position] + 1\n                \n                if neighbor not in cost_so_far or new_cost < cost_so_far[neighbor]:\n                    cost_so_far[neighbor] = new_cost\n                    came_from[neighbor] = current_position\n                    priority_queue_item = (new_cost, neighbor)\n                    heapq.heappush(priority_queue, priority_queue_item)\n    \n    # Reconstruct the path if needed\n    if goal in came_from:\n        path = [goal]\n        while path[-1] != start:\n            path.append(came_from[path[-1]])\n        return path[::-1]\n    \n    return None\n\n# Example grid with a boundary of '#' and open paths as ' '\ngrid = [\n    [' ', '#', '#', '#', '#'],\n    ['#', ' ', '#', ' ', '#'],\n    ['#', ' ', ' ', ' ', '#'],\n    ['#', '#', '#', ' ', '#'],\n    ['#', '#', 'G', '#', '#']\n]\n\nstart = (0, 1)  # Example start position\ngoal = (4, 2)   # Goal position\n\n# Find the shortest path from start to goal\nshortest_path = dijkstra(grid, start, goal)\nprint("Shortest path:", shortest_path)