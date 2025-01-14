import numpy as np\n\ndef calculate_angle(v1, v2):\n    # Calculate angle using arctan2 method for direction vectors\n    angle = np.arctan2(np.cross(v1,v2), np.dot(v1,v2))\n    return np.degrees(angle)  # Convert radians to degrees\n\ndef find_reflex_angles(vertices):\n    reflex_count = 0\n    n = len(vertices)\n    \n    for i in range(n):\n        v1 = np.array(vertices[(i - 1) % n]) - np.array(vertices[i])\n        v2 = np.array(vertices[(i + 1) % n]) - np.array(vertices[i])\n        \n        angle = calculate_angle(v1, v2)\n        \n        # If the polygon is concave and we have a convex angle\n        if angle < 0:\n            angle += 360\n        \n        # Check if it's a reflex angle\n        if angle > 180:\n            reflex_count += 1\n    \n    return reflex_count\n\n# Example usage:\nvertices = [(0, 0), (5, 0), (5, 5), (2, 7), (0, 5)]\nreflex_angles_count = find_reflex_angles(vertices)\nprint("Number of reflex angles:", reflex_angles_count)