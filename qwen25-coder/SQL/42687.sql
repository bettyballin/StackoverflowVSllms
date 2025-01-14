WITH RECURSIVE cte AS (\n  SELECT \n    id, parent_id, level, name, \n    CAST(name AS VARCHAR(255)) AS indented_name\n  FROM pages WHERE parent_id = 0\n  \n  UNION ALL\n\n  SELECT \n    p.id, p.parent_id, p.level, p.name,\n    CONCAT(REPEAT('~~', p.level - 1), p.name) AS indented_name\n  FROM pages p\n  INNER JOIN cte ON p.parent_id = cte.id\n)\nSELECT indented_name\nFROM cte\nORDER BY ARRAY_AGG(id) OVER(PARTITION BY id ORDER BY level);