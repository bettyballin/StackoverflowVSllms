function rayIntersectsPolygon(rayOrigin, rayVector, polygonVertices):\n    for i from 1 to len(polygonVertices) - 2:\n        vertex0 = polygonVertices[0]\n        vertex1 = polygonVertices[i]\n        vertex2 = polygonVertices[i + 1]\n        intersects, intersectionPoint = rayIntersectsTriangle(rayOrigin, rayVector, vertex0, vertex1, vertex2)\n        if intersects:\n            return true, intersectionPoint\n    return false, no intersectio