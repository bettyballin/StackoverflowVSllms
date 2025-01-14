WITH RECURSIVE category_tree AS (\n    SELECT id, parent_id, title, 1 AS level\n    FROM categories\n    WHERE parent_id = 0\n    UNION ALL\n    SELECT c.id, c.parent_id, c.title, ct.level + 1\n    FROM categories c\n    JOIN category_tree ct ON c.parent_id = ct.id\n)\nSELECT * FROM category_tree;