import random\n\n# Directions: right, down, left, up\nDIRECTIONS = [(0, 1), (1, 0), (0, -1), (-1, 0)]\n\ndef generate_maze(n, m):\n    # Initialize the grid with "walls"\n    maze = [['#' for _ in range(m)] for __ in range(n)]\n    \n    # Pick a random starting cell and mark it as part of the maze\n    start_i, start_j = random.randint(0, n-1), random.randint(0, m-1)\n    maze[start_i][start_j] = ' '\n\n    # List to track walls\n    walls = [(start_i + di, start_j + dj) for di, dj in DIRECTIONS if 0 <= start_i + di < n and 0 <= start_j + dj < m]\n    \n    while walls:\n        i, j = random.choice(walls)\n        \n        # Count the number of visited neighbors\n        neighbors = sum(maze[i+di][j+dj] == ' ' for di, dj in DIRECTIONS if 0 <= i + di < n and 0 <= j + dj < m)\n\n        # If exactly one neighbor is a path, then carve it out and add its walls to the list\n        if neighbors == 1:\n            maze[i][j] = ' '\n            for di, dj in DIRECTIONS:\n                ni, nj = i + di, j + dj\n                if 0 <= ni < n and 0 <= nj < m and maze[ni][nj] == '#':\n                    walls.append((ni, nj))\n        \n        # Remove the wall from the list\n        walls.remove((i, j))\n\n    return maze\n\ndef print_maze(maze):\n    for row in maze:\n        print(''.join(row))\n\n# Example usage\nn, m = 10, 20\nmaze = generate_maze(n, m)\nprint_maze(maze)