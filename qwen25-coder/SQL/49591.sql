WITH user_tags AS (\n    SELECT 'tag1' AS tag UNION ALL\n    SELECT 'tag2' UNION ALL\n    SELECT 'tag3'\n    -- Add more tags as necessary\n)\nSELECT ut.tag\nFROM user_tags ut\nLEFT JOIN tags t ON ut.tag = t.tag\nWHERE t.id IS NULL;