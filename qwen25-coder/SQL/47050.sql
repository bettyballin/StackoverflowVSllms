WITH RECURSIVE cte AS (\n    SELECT id, parentID, 1 as LEVEL     -- Start with level 1 for the root node\n      FROM node\n     WHERE id = :givenId               -- Your start node.\n UNION ALL\n    SELECT n.id, n.parentID, LEVEL + 1  -- Increment the level for each recursive step\n      FROM node n\n     INNER JOIN cte ON n.parentID = cte.id\n      WHERE LEVEL < :maxDepth            -- Stop recursion after reaching maxDepth\n)\nSELECT * FROM cte;