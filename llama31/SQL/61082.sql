SELECT * FROM (\n  SELECT * FROM parents WHERE x = 2\n) p\nINNER JOIN children c ON p.id = c.pid\nWHERE p.x = 2;