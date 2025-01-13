def subdivide_triangle(v1, v2, v3):\n    mid1 = (v1 + v2) / 2\n    mid2 = (v2 + v3) / 2\n    mid3 = (v3 + v1) / 2\n    return [\n        (v1, mid1, mid3),\n        (v2, mid1, mid2),\n        (v3, mid2, mid3),\n        (mid1, mid2, mid3),\n    ]