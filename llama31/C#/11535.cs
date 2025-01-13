public float GetLightingInformation(Vector point, ISceneObject[] scene, out Color color)\n{\n    int intersectCount = 0;\n    float distanceSum = 0;\n    Random rand = new Random();\n\n    for (int i = 0; i < _samples; i++)\n    {\n        Vector lightPoint = GetRandomPointOnLightSurface(rand);\n        Vector rayDir = lightPoint - point;\n        rayDir.Normalize();\n\n        bool intersects = false;\n        foreach (ISceneObject obj in scene)\n        {\n            Vector iPoint;\n            if (obj.Intersect(new Ray(point, rayDir), out iPoint))\n            {\n                intersects = true;\n                break;\n            }\n        }\n\n        if (intersects)\n        {\n            intersectCount++;\n        }\n        else\n        {\n            distanceSum += (lightPoint - point).Length;\n        }\n    }\n\n    float factor = 1 - ((float)intersectCount / _samples);\n    color = new Color(factor * Color.R, factor * Color.G, factor * Color.B);\n\n    return distanceSum / (_samples - intersectCount);\n}\n\nprivate Vector GetRandomPointOnLightSurface(Random rand)\n{\n    // Generate a random point on the light source's surface\n    // Assuming a spherical light source with radius _radius\n    float theta = (float)rand.NextDouble() * 2 * Math.PI;\n    float phi = (float)rand.NextDouble() * Math.PI;\n    float x = _radius * Math.Cos(theta) * Math.Sin(phi);\n    float y = _radius * Math.Sin(theta) * Math.Sin(phi);\n    float z = _radius * Math.Cos(phi);\n    return new Vector(x, y, z) + Location;\n}