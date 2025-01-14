function findRayIntersection(rayOrigin, rayDirection, vertices):\n    nearestIntersection = null\n    minDistance = infinity\n    \n    // Iterate through each edge of the polygon\n    for (i = 0; i < vertices.length; i++):\n        v1 = vertices[i]\n        v2 = vertices[(i + 1) % vertices.length]  // wrap around to first vertex\n        \n        // Compute the intersection point between the ray and this line segment\n        intersectionPoint = intersectRayWithSegment(rayOrigin, rayDirection, v1, v2)\n        \n        if (intersectionPoint is not null):\n            distance = length(distance(rayOrigin, intersectionPoint))\n            \n            // Check if this is the closest intersection found so far\n            if (distance < minDistance):\n                minDistance = distance\n                nearestIntersection = intersectionPoint\n                \n    return nearestIntersection\n\nfunction intersectRayWithSegment(rayOrigin, rayDirection, v1, v2):\n    // Compute vector from the polygon edge start point to the ray origin\n    e0 = rayOrigin - v1\n    \n    // Compute direction vectors for the edge and the ray\n    d0 = v2 - v1\n    da = normalize(rayDirection)\n    \n    // Solve using Cramer's rule matrix invertions:\n    numerator = dot(d0, cross(da, e0))\n    denominator = dot(cross(d0, da), normalOfTriangle(v1, v2, rayOrigin + da))\n    \n    if (denominator == 0):\n        return null // Ray is parallel to edge or does not intersect the triangle\n    \n    // Ratio of plane intersection\n    t1 = numerator / denominator\n    \n    if (t1 < 0):\n        return null // Intersection point is behind the ray origin\n    \n    d2 = cross(e0, da) * invdet  // Cross product for second part of Cramer's rule\n    \n    u = dot(d2, d0)\n    \n    if (u < 0 or u > 1):\n        return null // Intersection point outside segment bounds\n    \n    v = dot(d2, rayDirection)\n    if (v < 0 or (u + v) > 1):\n        return null // Intersection point outside segment bounds\n    \n    intersectionPoint = rayOrigin + da * t1\n    return intersectionPoint\n\nfunction normalOfTriangle(p1, p2, p3):\n    edge1 = p2 - p1\n    edge2 = p3 - p1\n    return normalize(cross(edge1, edge2))