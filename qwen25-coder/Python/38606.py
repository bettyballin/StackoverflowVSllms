from PIL import Image, ImageDraw\nimport imageio\n\ndef create_knights_tour_gif(board_size, knight_moves):\n    frames = []\n    # Create a new board with all cells as blue initially\n    board_image = Image.new('RGB', (board_size * 50, board_size * 50), color='blue')\n    draw = ImageDraw.Draw(board_image)\n    \n    # Add the initial frame to the list of frames\n    frames.append(Image.fromarray(board_image))\n    \n    for index, move in enumerate(knight_moves):\n        row, col = move\n        # Change the current cell to red\n        x0, y0 = col * 50 + 1, row * 50 + 1\n        x1, y1 = (col + 1) * 50 - 1, (row + 1) * 50 - 1\n        draw.rectangle([x0, y0, x1, y1], fill='red')\n        \n        # Append the current frame to the frames list\n        if index % 5 == 0:  # Add every 5th move as a new frame for visualization purposes\n            frames.append(Image.fromarray(board_image))\n    \n    # Save the frames as an animated GIF\n    imageio.mimsave('knights_tour.gif', frames, duration=0.1)\n\n# Example knight's moves on an 8x8 board (replace with actual moves)\nknight_moves = [(0, 0), (2, 1), (4, 2), (6, 3), ...]  # fill in the rest of the moves\ncreate_knights_tour_gif(8, knight_moves)