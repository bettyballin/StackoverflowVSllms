SELECT C1, C2, C3\nFROM (\n  SELECT C1, C2, C3 FROM T1\n  UNION ALL\n  SELECT C1, C2, C3 FROM T2\n)\nORDER BY C3;