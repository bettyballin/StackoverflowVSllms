import math\n\ndef next_power_of_2(x):\n    return 2 ** (x-1).bit_length()\n\nclass Rectangle:\n    def __init__(self, width, height):\n        self.width = width\n        self.height = height\n\ndef get_min_container(rectangles, max_size_dimension=4096):\n    # Sort rectangles by area in descending order to fill large spaces first\n    rectangles.sort(key=lambda x: x.width * x.height, reverse=True)\n    \n    # Initial container size should be the largest rectangle's width and height\n    current_width = next_power_of_2(max(rect.width for rect in rectangles))\n    current_height = next_power_of_2(max(rect.height for rect in rectangles))\n    \n    while current_width <= max_size_dimension and current_height <= max_size_dimension:\n        layout = [[0] * current_height for _ in range(current_width)]\n        success, height_used = bl_pack(rectangles, layout)\n        \n        if success:\n            # If packing successful and within power of two constraints\n            return current_width, min(current_height, next_power_of_2(height_used))\n        else:\n            # Expand container size and try again\n            current_height *= 2\n            \n            # If height has doubled beyond width, increase width too\n            if current_height > current_width:\n                current_width *= 2\n    return -1, -1  # Return failure\n\ndef bl_pack(rectangles, layout):\n    # Bottom-left heuristic for packing rectangles into the layout\n    used_height = 0\n    width, height = len(layout), len(layout[0])\n    \n    def find_place(rect):\n        min_y = float('inf')\n        best_x = -1\n        best_y = -1\n        \n        for y in range(height):\n            x = 0\n            while x < width:\n                if not layout[x][y]:\n                    # Mark the current rectangle's position, considering rotation\n                    can_place_width = False\n                    can_rotate_and_place = False\n                    \n                    if all(layout[x + dx][y] == 0 for dx in range(rect.width) if x + dx < width):\n                        can_place_width = True\n                        min_y = y\n                \n                    # Check if rotating the rectangle fits better\n                    if rect.height <= height and rect.width <= width:\n                        if all(layout[x + dy][y + dx] == 0 for dy in range(rect.height) for dx in range(rect.width) if x + dy < width and y + dx < height):\n                            can_rotate_and_place = True\n                            min_y = min(min_y, y)\n                    \n                    # Use the best placement found\n                    if can_place_width or can_rotate_and_place:\n                        if can_place_width:\n                            best_x = x\n                            best_y = min_y\n                            return best_x, best_y, False\n                        \n                        elif can_rotate_and_place:\n                            best_x = x\n                            best_y = min_y\n                            return best_x, best_y, True\n                \n                while x < width and layout[x][y]:\n                    x += 1\n        \n        return -1, -1, False\n\n    for rect in rectangles:\n        x_start, y_start, rotated = find_place(rect)\n        \n        if x_start == -1 or y_start == -1:\n            # Could not place rectangle\n            return False, used_height\n        \n        w = rect.height if rotated else rect.width\n        h = rect.width if rotated else rect.height\n        \n        for dy in range(h):\n            for dx in range(w):\n                layout[x_start + dx][y_start + dy] = 1\n        \n        # Update the height used in the packing so far\n        used_height = max(used_height, y_start + h)\n    \n    return True, used_height\n\n# Example usage:\nrectangles = [\n    Rectangle(128, 32),\n    Rectangle(128, 64),\n    Rectangle(64, 32),\n    Rectangle(64, 32),\n    Rectangle(160, 32),\n    Rectangle(64, 64)\n]\n\ncontainer_width, container_height = get_min_container(rectangles)\nprint(f"Container Dimensions: {container_width}x{container_height}")