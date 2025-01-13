import numpy as np\n\ndef angle_between_vectors(v1, v2):\n    """Compute the angle in degrees between vectors 'v1' and 'v2'"""\n    unit_vector_1 = v1 / np.linalg.norm(v1)\n    unit_vector_2 = v2 / np.linalg.norm(v2)\n    dot_product = np.dot(unit_vector_1, unit_vector_2)\n    angle = np.arccos(dot_product)\n    return np.degrees(angle)\n\ndef is_reflex_angle(v1, v2, v3):\n    """Check if the angle at point v2 formed by v1-v2-v3 is a reflex angle (>180 degrees)"""\n    a = np.array(v1)\n    b = np.array(v2)\n    c = np.array(v3)\n    ab = a - b\n    cb = c - b\n    angle = angle_between_vectors(ab, cb)\n    # Check if it's a reflex angle\n    return angle > 180\n\ndef count_reflex_angles(vertices):\n    """Count the number of reflex angles in a polygon given its vertices"""\n    n = len(vertices)\n    reflex_count = 0\n    for i in range(n):\n        if is_reflex_angle(vertices[i - 1], vertices[i], vertices[(i + 1) % n]):\n            reflex_count += 1\n    return reflex_count\n\n# Example usage:\nvertices = [(0, 0), (4, 0), (4, 3), (0, 4)]\nprint("Number of internal angles greater than 180º:", count_reflex_angles(vertices))