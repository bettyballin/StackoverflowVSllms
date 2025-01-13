public float GetLightingInformation(Vector point, ISceneObject[] scene, out Color color)\n{\n    Random random = new Random();\n    int intersectCount = 0;\n    double totalDistance = 0;\n\n    for (int i = 0; i < _samples; i++)\n    {\n        bool intersects = false;\n        \n        // Generate a random point on the light's surface\n        float randX = _radius - (float)(random.NextDouble() * (2 * _radius));\n        float randY = _radius - (float)(random.NextDouble() * (2 * _radius));\n        float randZ = _radius - (float)(random.NextDouble() * (2 * _radius));\n\n        Vector sampleLocation = new Vector(Location.X + randX, Location.Y + randY, Location.Z + randZ);\n        Vector rayDirection = sampleLocation - point;\n\n        foreach (ISceneObject obj in scene)\n        {\n            Vector iPoint;\n            if (obj.Intersect(new Ray(point, rayDirection), out iPoint))\n            {\n                intersects = true;\n                break; // No need to check other objects once there's an intersection\n            }\n        }\n\n        if (!intersects)\n        {\n            totalDistance += rayDirection.Length();\n        }\n        else\n        {\n            intersectCount++;\n        }\n    }\n\n    float factor = 1 - ((float)intersectCount / _samples);\n    color = new Color(factor * Color.R, factor * Color.G, factor * Color.B);\n\n    if (_samples - intersectCount == 0)\n    {\n        return float.MaxValue; // If no light rays reach the point, treat it as shadowed\n    }\n\n    return (float)(totalDistance / (_samples - intersectCount));\n}