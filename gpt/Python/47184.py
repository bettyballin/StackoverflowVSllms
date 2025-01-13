def is_valid_sudoku(board):\n    def is_valid_block(block):\n        block = [num for num in block if num != '.']\n        return len(block) == len(set(block))\n\n    # Check rows\n    for row in board:\n        if not is_valid_block(row):\n            return False\n\n    # Check columns\n    for col in zip(*board):\n        if not is_valid_block(col):\n            return False\n\n    # Check 3x3 sub-grids\n    for i in range(0, 9, 3):\n        for j in range(0, 9, 3):\n            block = [board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]\n            if not is_valid_block(block):\n                return False\n\n    return True\n\n# Example usage:\nsudoku_board = [\n    ["5","3",".",".","7",".",".",".","."],\n    ["6",".",".","1","9","5",".",".","."],\n    [".","9","8",".",".",".",".","6","."],\n    ["8",".",".",".","6",".",".",".","3"],\n    ["4",".",".","8",".","3",".",".","1"],\n    ["7",".",".",".","2",".",".",".","6"],\n    [".","6",".",".",".",".","2","8","."],\n    [".",".",".","4","1","9",".",".","5"],\n    [".",".",".",".","8",".",".","7","9"]\n]\n\nprint(is_valid_sudoku(sudoku_board)) # Output: True or False depending on validity