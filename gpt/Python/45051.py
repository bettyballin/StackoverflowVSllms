from shapely.geometry import Polygon\nfrom shapely.affinity import rotate\n\ndef calculate_bounding_rectangle(polygon_points, angle):\n    # Create a polygon from the points\n    polygon = Polygon(polygon_points)\n    \n    # Rotate the polygon\n    rotated_polygon = rotate(polygon, angle, origin='centroid', use_radians=False)\n    \n    # Get the bounding box of the rotated polygon\n    minx, miny, maxx, maxy = rotated_polygon.bounds\n    \n    # Define the corners of the bounding rectangle\n    bounding_rect_points = [(minx, miny), (minx, maxy), (maxx, maxy), (maxx, miny)]\n    \n    # Rotate the bounding rectangle back to the original angle\n    rotated_bounding_rect = rotate(Polygon(bounding_rect_points), -angle, origin='centroid', use_radians=False)\n    \n    return list(rotated_bounding_rect.exterior.coords)\n\n# Example usage\npolygon_points = [(0, 0), (1, 0), (1, 1), (0, 1)]\nangle = 45  # Angle in degrees\nbounding_rectangle = calculate_bounding_rectangle(polygon_points, angle)\nprint(bounding_rectangle)