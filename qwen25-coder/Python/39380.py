function findFurthestPoints(grid):\n    // BFS function to find the farthest node and distance\n    function bfs(startPoint):\n        queue = new Queue()\n        visited = 2D array of size grid, initialized with false\n        distances = 2D array of same size as grid, initialized with infinity\n        queue.enqueue(startPoint)\n        visited[startPoint] = true\n        distances[startPoint] = 0\n\n        while not queue.isEmpty():\n            currentPoint = queue.dequeue()\n\n            for each neighbor (up, down, left, right):\n                if isValid(neighbor) and not visited[neighbor]:\n                    visited[neighbor] = true\n                    queue.enqueue(neighbor)\n                    distances[neighbor] = distances[currentPoint] + 1\n\n        // Find the furthest point and its distance\n        maxDistance = 0\n        farthestPoint = startPoint\n        for each point in grid:\n            if distances[point] > maxDistance:\n                maxDistance = distances[point]\n                farthestPoint = point\n        return farthestPoint, maxDistance\n\n    // Step 1: Find any valid starting point\n    start = findAnyUnblockedCell(grid)\n    \n    // Step 2: Perform BFS to get the farthest point from start\n    p1, _ = bfs(start)\n    \n    // Step 3: Perform another BFS from the furthest found to find the goal\n    goal, maxDistance = bfs(p1)\n\n    return p1, goal, maxDistance\n\nfunction isValid(point):\n    return point is within grid bounds and grid[point] == 'nonblocked'