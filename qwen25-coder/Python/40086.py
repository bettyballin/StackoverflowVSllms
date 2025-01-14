def bezier_point(p0, p1, p2, p3, t):\n    """Calculate the point on a cubic Bezier curve at a given t"""\n    return (\n        (1 - t)**3 * p0 + \n        3 * (1 - t)**2 * t * p1 +\n        3 * (1 - t) * t**2 * p2 +\n        t**3 * p3\n    )\n\ndef generate_grid_points(edge_points, grid_size):\n    """\n    Generate points on a grid inside a shape with 4 curved Bezier edges.\n    edge_points is a list of [(p0, p1, p2, p3)] where each tuple contains the control points for one Bezier curve.\n    grid_size defines how many points along the curve to calculate for t in [0, 1].\n    """\n    step = 1.0 / (grid_size - 1)\n    \n    # Generate points on all four edges\n    edge_points_list = []\n    for i, (p0, p1, p2, p3) in enumerate(edge_points):\n        points_on_edge = [bezier_point(p0, p1, p2, p3, t) for t in [i * step for i in range(grid_size)]]\n        edge_points_list.append(points_on_edge)\n    \n    # Generate grid inside the shape\n    grid_points = []\n    for u in [i * step for i in range(grid_size)]:\n        for v in [i * step for i in range(grid_size)]:\n            # Interpolate between points on opposite edges\n            top_point = bezier_point(\n                edge_points_list[0][int(u * grid_size)], \n                edge_points_list[1][int(u * grid_size)], \n                edge_points_list[2][int(u * grid_size)], \n                edge_points_list[3][int(u * grid_size)], \n                v\n            )\n            bottom_point = bezier_point(\n                edge_points_list[0][int((u + step) * grid_size - 1)], \n                edge_points_list[1][int((u + step) * grid_size - 1)], \n                edge_points_list[2][int((u + step) * grid_size - 1)], \n                edge_points_list[3][int((u + step) * grid_size - 1)], \n                v\n            )\n            # Interpolate vertically between top and bottom points for each column\n            point = bezier_point(top_point, bottom_point, (0, 1), (0, 1), u)\n            grid_points.append(point)\n            \n    return grid_points\n\n# Example usage:\nedge_points = [\n    ((0, 0), (25, -75), (75, -30), (100, 0)),  # Control points for the first edge\n    ((100, 0), (175, -75), (225, -30), (250, 0)),  # Second edge\n    ((250, 0), (225, 75), (175, 30), (100, 0)),  # Third edge\n    ((100, 0), (25, 75), (75, 30), (0, 0))  # Fourth edge\n]\n\ngrid_points = generate_grid_points(edge_points, grid_size=4)\nfor point in grid_points:\n    print(point)