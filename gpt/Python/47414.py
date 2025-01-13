import math\n\ndef dist(p1, p2):\n    return math.sqrt((p2[0] - p1[0])**2 + (p2[1] - p1[1])**2)\n\npoints = [[x1, y1], [x2, y2], [x3, y3], ...]\npoint_to_compare = [X, Y]\n\nclosest_point = min(points, key=lambda point: dist(point, point_to_compare))\nprint(closest_point)