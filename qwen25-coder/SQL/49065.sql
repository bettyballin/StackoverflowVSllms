WITH RECURSIVE category_hierarchies AS (\n    SELECT \n        category_id,\n        CAST(category_id AS CHAR(255)) AS path\n    FROM categories\n    WHERE parent IS NULL\n\n    UNION ALL\n\n    SELECT \n        c.category_id,\n        CONCAT(ch.path, ',', c.category_id) AS path\n    FROM categories c\n    INNER JOIN category_hierarchies ch ON c.parent = ch.category_id\n)\nSELECT \n    category_id,\n    SUBSTRING_INDEX(path, ',', 1) AS lvl1,\n    SUBSTRING_INDEX(SUBSTRING_INDEX(path, ',', 2), ',', -1) AS lvl2,\n    SUBSTRING_INDEX(SUBSTRING_INDEX(path, ',', 3), ',', -1) AS lvl3,\n    SUBSTRING_INDEX(SUBSTRING_INDEX(path, ',', 4), ',', -1) AS lvl4\nFROM category_hierarchies\nORDER BY path;