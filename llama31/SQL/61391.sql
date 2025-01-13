WITH RECURSIVE redirect_list AS (\n  SELECT id, redirectid, data, 0 AS level\n  FROM your_table\n  WHERE id = ?  -- start with the given id\n  UNION ALL\n  SELECT t.id, t.redirectid, t.data, level + 1\n  FROM your_table t\n  JOIN redirect_list r ON t.id = r.redirectid\n)\nSELECT id\nFROM redirect_list\nWHERE redirectid IS NULL;  -- get the id at the end of the list