import math\n\ndef orientation(p, q, r):\n    val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])\n    if val == 0: return 0  # Collinear\n    return 1 if val > 0 else -1  # Clockwise or counterclockwise\n\ndef convex_hull(points):\n    n = len(points)\n    hull = []\n    l = 0\n    for i in range(1, n):\n        if points[i][0] < points[l][0]:\n            l = i\n\n    p = l\n    while True:\n        hull.append(points[p])\n        q = (p + 1) % n\n\n        for i in range(n):\n            if orientation(points[p], points[i], points[q]) == -1:\n                q = i\n\n        p = q\n        if p == l: break\n\n    return hull\n\n# Example usage:\npoints = [(0, 3), (1, 1), (2, 2), (4, 4), (0, 0), (1, 2), (3, 1), (3, 3)]\nhull = convex_hull(points)\nprint(hull)