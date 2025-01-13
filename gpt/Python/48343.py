def count_neighbors(grid, x, y):\n    neighbor_positions = [(-1, -1), (-1, 0), (-1, 1),\n                          (0, -1),         (0, 1),\n                          (1, -1), (1, 0), (1, 1)]\n    count = 0\n    for dx, dy in neighbor_positions:\n        nx, ny = x + dx, y + dy\n        if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]):\n            count += grid[nx][ny]\n    return count\n\ndef game_of_life(grid):\n    rows, cols = len(grid), len(grid[0])\n    new_grid = [[0]*cols for _ in range(rows)]\n    \n    for i in range(rows):\n        for j in range(cols):\n            neighbors = count_neighbors(grid, i, j)\n            if grid[i][j] == 1:\n                if neighbors < 2 or neighbors > 3:\n                    new_grid[i][j] = 0\n                else:\n                    new_grid[i][j] = 1\n            else:\n                if neighbors == 3:\n                    new_grid[i][j] = 1\n    \n    return new_grid\n\n# Example usage:\ninitial_grid = [\n    [0, 1, 0],\n    [0, 1, 0],\n    [0, 1, 0]\n]\n\nnext_gen = game_of_life(initial_grid)\nfor row in next_gen:\n    print(row)