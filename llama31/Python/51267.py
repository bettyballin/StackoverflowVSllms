def rdp(points, epsilon):\n    if len(points) < 3:\n        return points\n\n    dmax = 0\n    index = 0\n    for i in range(1, len(points) - 1):\n        d = perpendicular_distance(points[0], points[-1], points[i])\n        if d > dmax:\n            index = i\n            dmax = d\n\n    if dmax > epsilon:\n        results = rdp(points[:index+1], epsilon) + rdp(points[index:], epsilon)\n    else:\n        results = [points[0], points[-1]]\n\n    return results\n\ndef perpendicular_distance(p1, p2, p):\n    x0, y0 = p\n    x1, y1 = p1\n    x2, y2 = p2\n    return abs((x2 - x1) * (y1 - y0) - (x1 - x0) * (y2 - y1)) / ((x2 - x1)**2 + (y2 - y1)**2)**0.5