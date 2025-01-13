SELECT \n  COALESCE(t1.Id, t2.Id) AS Id,\n  COALESCE(t1.Name, t2.Name) AS Name\nFROM \n  Table1 t1\nFULL OUTER JOIN \n  Table2 t2\nON \n  t1.Id = t2.Id\nWHERE \n  t1.Id IS NULL OR t2.Id IS NULL;