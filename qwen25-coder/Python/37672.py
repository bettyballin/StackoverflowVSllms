def is_visible(grid, start_x, start_y, end_x, end_y):\n    dx = abs(end_x - start_x)\n    dy = -abs(end_y - start_y)\n    sx = 1 if start_x < end_x else -1\n    sy = 1 if start_y < end_y else -1\n\n    err = dx + dy\n    while True:\n        if grid[start_x][start_y] == 'W':  # Assume 'W' denotes a wall\n            return False\n        if (start_x, start_y) == (end_x, end_y):\n            return True\n        e2 = 2 * err\n        if e2 > dy:\n            err += dy\n            start_x += sx\n        if e2 < dx:\n            err += dx\n            start_y += sy\n\n# Example usage\ngrid_size = 10\ngrid = [[' ']*grid_size for _ in range(grid_size)]\n\n# Adding some walls ('W')\ngrid[3][4] = grid[4][5] = 'W'\n\nprint(is_visible(grid, 2, 3, 6, 7))  # Returns False if path blocked by wall