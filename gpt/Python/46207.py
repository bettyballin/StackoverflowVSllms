def map_to_x_from_y(y_value):\n    # Define the linear ranges for X\n    x_ranges = [(100, 200), (300, 400), (500, 600), (700, 900)]\n    total_x_length = sum(r[1] - r[0] for r in x_ranges)\n    \n    # Define the linear range for Y\n    y_range = (0, 100)\n    total_y_length = y_range[1] - y_range[0]\n    \n    # Calculate the scaling factor\n    scaling_factor = total_x_length / total_y_length\n    \n    # Convert Y value to equivalent X value\n    y_scaled = y_value * scaling_factor\n    \n    # Find the corresponding X range and map the value\n    current_length = 0\n    for start, end in x_ranges:\n        range_length = end - start\n        if current_length + range_length >= y_scaled:\n            x_value = start + (y_scaled - current_length)\n            return x_value\n        current_length += range_length\n    \n    raise ValueError("Y value out of range")\n\n\ndef map_to_y_from_x(x_value):\n    # Define the linear ranges for X\n    x_ranges = [(100, 200), (300, 400), (500, 600), (700, 900)]\n    total_x_length = sum(r[1] - r[0] for r in x_ranges)\n    \n    # Define the linear range for Y\n    y_range = (0, 100)\n    total_y_length = y_range[1] - y_range[0]\n    \n    # Calculate the scaling factor\n    scaling_factor = total_y_length / total_x_length\n    \n    # Find the corresponding Y value\n    current_length = 0\n    for start, end in x_ranges:\n        range_length = end - start\n        if start <= x_value < end:\n            x_scaled = current_length + (x_value - start)\n            y_value = x_scaled * scaling_factor\n            return y_value\n        current_length += range_length\n    \n    raise ValueError("X value out of range")\n\n# Example usage:\ny_value = 50\nx_value = map_to_x_from_y(y_value)\nprint(f"The equivalent X value for Y={y_value} is X={x_value}")\n\nx_value = 450\ny_value = map_to_y_from_x(x_value)\nprint(f"The equivalent Y value for X={x_value} is Y={y_value}")