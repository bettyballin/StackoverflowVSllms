import math\nfrom scipy.spatial import ConvexHull\n\ndef euclidean_distance(p1, p2):\n    return math.sqrt((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2)\n\ndef rotating_calipers(points):\n    hull = ConvexHull(points)\n    hull_points = [points[i] for i in hull.vertices]\n    \n    max_distance = 0\n    k = 1\n    n = len(hull_points)\n    \n    for i in range(n):\n        while True:\n            current_distance = euclidean_distance(hull_points[i], hull_points[k])\n            next_k = (k + 1) % n\n            next_distance = euclidean_distance(hull_points[i], hull_points[next_k])\n            if next_distance > current_distance:\n                k = next_k\n            else:\n                break\n        max_distance = max(max_distance, euclidean_distance(hull_points[i], hull_points[k]))\n    \n    return max_distance\n\n# Example usage\npoints = [(0, 0), (1, 1), (2, 2), (3, 1), (4, 0), (2, -1)]\nprint("Greatest Linear Dimension:", rotating_calipers(points))