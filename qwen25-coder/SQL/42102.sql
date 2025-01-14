SELECT ID, SUM(Count) AS TotalCount\nFROM (\n    SELECT ID, COUNT(*) AS Count FROM [Table1]\n    UNION ALL\n    SELECT ID, COUNT(*) AS Count FROM [Table2]\n) AS CombinedResults\nGROUP BY ID;