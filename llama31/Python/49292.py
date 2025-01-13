def polygon_area(vertices):\n    n = len(vertices)\n    area = 0\n    for i in range(n):\n        j = (i + 1) % n\n        area += vertices[i][0] * vertices[j][1]\n        area -= vertices[j][0] * vertices[i][1]\n    return abs(area) / 2