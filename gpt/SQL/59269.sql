SELECT a.someRow, b.someRow\nFROM tableA AS a\nINNER JOIN tableB AS b ON a.ID = b.ID\nWHERE b.ID = $someVar;