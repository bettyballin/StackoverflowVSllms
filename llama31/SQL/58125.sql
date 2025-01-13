WITH RECURSIVE dependencies AS (\n  SELECT \n    table_name, \n    referenced_table_name, \n    0 AS level\n  FROM \n    all_constraints \n  WHERE \n    constraint_type = 'R' \n    AND table_name = :tablename  -- start with the given table\n  UNION ALL\n  SELECT \n    c.table_name, \n    c.referenced_table_name, \n    level + 1\n  FROM \n    all_constraints c\n  JOIN \n    dependencies d ON c.table_name = d.referenced_table_name\n  WHERE \n    c.constraint_type = 'R'\n)\nSELECT * FROM dependencies;