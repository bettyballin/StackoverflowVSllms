SELECT value\nFROM (\n  SELECT a AS value, 1 AS order_col FROM A LIMIT 1\n  UNION\n  SELECT b AS value, 2 AS order_col FROM B LIMIT 1\n) subquery\nORDER BY order_col;