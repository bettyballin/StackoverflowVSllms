SELECT *\nFROM YourTable t\nWHERE NOT EXISTS (\n  SELECT 1\n  FROM YourTable\n  WHERE YourColumn IS NULL\n  AND rowid = t.rowid\n);