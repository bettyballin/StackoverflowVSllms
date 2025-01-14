import math\n\ndef is_point_in_semi_circle(point, center, radius, start_angle, end_angle):\n    x, y = point\n    h, k = center\n    \n    # Vector from center to point\n    dx = x - h\n    dy = y - k\n    \n    # Distance from center to point squared\n    dist_squared = dx * dx + dy * dy\n    if dist_squared > radius * radius:\n        return False  # Point is outside the circle\n    \n    # Calculate angle of vector (dx, dy) relative to positive x-axis\n    point_angle = math.atan2(dy, dx)\n    \n    # Normalize angle to [0, 2*pi)\n    if point_angle < 0:\n        point_angle += 2 * math.pi\n    \n    # Check if the point is within the semi-circle's angular range\n    return start_angle <= point_angle <= end_angle\n\n# Example usage\ncenter = (0, 0)\nradius = 5\nstart_angle = 0  # Start of semi-circle in radians\nend_angle = math.pi  # End of semi-circle in radians\n\npoints = [(-4, 3), (3, -3), (4, 0)]\npoints_in_semi_circle = [p for p in points if is_point_in_semi_circle(p, center, radius, start_angle, end_angle)]\n\nprint(points_in_semi_circle)