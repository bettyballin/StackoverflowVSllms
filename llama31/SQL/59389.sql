SELECT *\nFROM (\n  SELECT RANK() OVER (ORDER BY tbl1.points DESC) rank,\n         tbl1.col1, ..., tbl1.points\n  FROM table1 tbl1\n  JOIN table2 tbl2 ON tbl1.tbl2FK = tbl2.PK\n  WHERE tbl2.col1 = :someNumber\n    AND tbl1.dateColumn = :dateParam\n) s\nWHERE s.rank <= 3;