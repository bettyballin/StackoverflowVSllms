SELECT  *\nFROM db1.entry e\nWHERE NOT EXISTS (\n  SELECT 1\n  FROM db2.content c\n  WHERE c.entry_id = e.entry_id\n)