WITH MyDATASET AS (\n  SELECT x, y, z FROM table1\n  UNION ALL\n  SELECT k, l, m FROM table2\n)\nSELECT * FROM MyDATASET;