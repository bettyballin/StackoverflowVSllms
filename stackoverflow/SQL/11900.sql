SELECT n, COUNT(*) as freq FROM \n(\n  SELECT n1 AS n FROM lottery\n  UNION ALL\n  SELECT n2 FROM lottery\n  UNION ALL\n  SELECT n3 FROM lottery\n  UNION ALL\n  SELECT n4 FROM lottery\n  UNION ALL\n  SELECT n5 FROM lottery\n  UNION ALL\n  SELECT n6 FROM lottery\n) as transposed\nGROUP BY n\nORDER BY COUNT(*) DESC