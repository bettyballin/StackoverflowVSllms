def is_valid(board, row, col, num):\n    # Check row and column\n    for i in range(4):\n        if board[row][i] == num or board[i][col] == num:\n            return False\n\n    # Check 2x2 sub-grid\n    sub_grid_row = row // 2\n    sub_grid_col = col // 2\n    for i in range(2):\n        for j in range(2):\n            if board[sub_grid_row * 2 + i][sub_grid_col * 2 + j] == num:\n                return False\n\n    return True\n\ndef generate_sudoku_board(board):\n    for row in range(4):\n        for col in range(4):\n            if board[row][col] == 0:\n                for num in range(1, 5):\n                    if is_valid(board, row, col, num):\n                        board[row][col] = num\n                        if generate_sudoku_board(board):\n                            return True\n                        board[row][col] = 0\n                return False\n    return True\n\n# Initialize an empty board\nboard = [[[0 for _ in range(4)] for _ in range(4)] for _ in range(4)]\n\n# Generate a Sudoku board\ngenerate_sudoku_board(board)\n\n# Print the board\nfor layer in board:\n    for row in layer:\n        print(row)\n    print()