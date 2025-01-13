import matplotlib.pyplot as plt\n\ndef graham_scan(points):\n    # Find the point with the lowest y-coordinate, break ties by x-coordinate\n    start = min(points, key=lambda p: (p[1], p[0]))\n    points.pop(points.index(start))\n\n    # Sort the points by polar angle with respect to the start point\n    points.sort(key=lambda p: (polar_angle(start, p), -distance(start, p)))\n\n    hull = [start]\n    for point in points:\n        while len(hull) > 1 and not ccw(hull[-2], hull[-1], point):\n            hull.pop()\n        hull.append(point)\n    \n    return hull\n\ndef polar_angle(p0, p1):\n    from math import atan2\n    return atan2(p1[1] - p0[1], p1[0] - p0[0])\n\ndef distance(p0, p1):\n    return (p1[0] - p0[0]) ** 2 + (p1[1] - p0[1]) ** 2\n\ndef ccw(p0, p1, p2):\n    return (p1[0] - p0[0]) * (p2[1] - p0[1]) > (p1[1] - p0[0]) * (p2[0] - p0[0])\n\n# Example usage:\npoints = [(0, 3), (1, 1), (2, 2), (4, 4), (0, 0), (1, 2), (3, 1), (3, 3)]\nhull = graham_scan(points)\n\n# Plotting the points and the convex hull\nx, y = zip(*points)\nplt.scatter(x, y)\n\nhx, hy = zip(*hull + [hull[0]])\nplt.plot(hx, hy, 'r-')\n\nplt.show()