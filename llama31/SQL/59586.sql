SELECT *\nFROM Table1\nORDER BY CASE\n  WHEN Value < (SELECT Threshold FROM Table2 WHERE Table1.ForeignKey = Table2.PrimaryKey) THEN 0\n  ELSE 1\nEND;