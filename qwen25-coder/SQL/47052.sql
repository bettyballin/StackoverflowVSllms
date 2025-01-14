WITH RECURSIVE cte AS (\n    SELECT id, parentID\n      FROM node\n     WHERE id = :givenId          -- Start with the given node as root of recursion\n UNION ALL\n    SELECT n.id, n.parentID\n      FROM node n\n     INNER JOIN cte ON n.parentID = cte.id  -- Join to find children recursively\n)\nSELECT * FROM cte;