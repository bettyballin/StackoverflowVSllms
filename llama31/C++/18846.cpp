struct Object {\n    int id;\n    float x, y, z;\n};\n\nstruct SpatialIndex {\n    std::vector<Object> objects;\n    std::vector<std::vector<int>> grid;\n\n    void addObject(const Object& obj) {\n        int gridX = static_cast<int>(obj.x / cellSize);\n        int gridY = static_cast<int>(obj.y / cellSize);\n        grid[gridX][gridY].push_back(obj.id);\n    }\n\n    std::vector<Object> getObjectsInRegion(float minX, float minY, float maxX, float maxY) {\n        std::vector<Object> result;\n        int gridMinX = static_cast<int>(minX / cellSize);\n        int gridMinY = static_cast<int>(minY / cellSize);\n        int gridMaxX = static_cast<int>(maxX / cellSize);\n        int gridMaxY = static_cast<int>(maxY / cellSize);\n\n        for (int x = gridMinX; x <= gridMaxX; ++x) {\n            for (int y = gridMinY; y <= gridMaxY; ++y) {\n                for (int id : grid[x][y]) {\n                    result.push_back(objects[id]);\n                }\n            }\n        }\n        return result;\n    }\n};