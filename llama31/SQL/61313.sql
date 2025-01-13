WITH RECURSIVE category_hierarchy AS (\n  SELECT category_id, name, parent, 1 AS level\n  FROM categories\n  WHERE parent IS NULL\n  UNION ALL\n  SELECT c.category_id, c.name, c.parent, level + 1\n  FROM categories c\n  JOIN category_hierarchy p ON c.parent = p.category_id\n)\nSELECT \n  category_id,\n  MAX(CASE WHEN level = 1 THEN category_id END) AS lvl1,\n  MAX(CASE WHEN level = 2 THEN category_id END) AS lvl2,\n  MAX(CASE WHEN level = 3 THEN category_id END) AS lvl3,\n  MAX(CASE WHEN level = 4 THEN category_id END) AS lvl4\nFROM category_hierarchy\nGROUP BY category_id\nORDER BY category_id;