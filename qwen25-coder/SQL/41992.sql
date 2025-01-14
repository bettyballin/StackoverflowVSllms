DECLARE @Test TABLE ([Sets] INT, [Reps] INT);\n\nINSERT INTO @Test VALUES (2, 10);\nINSERT INTO @Test VALUES (3, 15);\nINSERT INTO @Test VALUES (3, 12);\nINSERT INTO @Test VALUES (4, 8);\n\nSELECT CAST([Reps] AS VARCHAR(10)) + \n       REPLICATE(',' + CAST([Reps] AS VARCHAR(10)), [Sets] - 1)\n       AS [RepsConcatenated]\nFROM @Test;