DECLARE @SQL NVARCHAR(MAX);\nSET @SQL = N'SELECT Year, ''Week1'' AS Week, Week1 AS Sales FROM YourTable \nUNION ALL SELECT Year, ''Week2'', Week2 FROM YourTable';\n\nWITH Numbers AS (\n    SELECT 3 AS n UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6\n    UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10\n    UNION ALL SELECT 11 UNION ALL SELECT 12 UNION ALL SELECT 13 UNION ALL SELECT 14\n    UNION ALL SELECT 15 UNION ALL SELECT 16 UNION ALL SELECT 17 UNION ALL SELECT 18\n    UNION ALL SELECT 19 UNION ALL SELECT 20 UNION ALL SELECT 21 UNION ALL SELECT 22\n    UNION ALL SELECT 23 UNION ALL SELECT 24 UNION ALL SELECT 25 UNION ALL SELECT 26\n    UNION ALL SELECT 27 UNION ALL SELECT 28 UNION ALL SELECT 29 UNION ALL SELECT 30\n    UNION ALL SELECT 31 UNION ALL SELECT 32 UNION ALL SELECT 33 UNION ALL SELECT 34\n    UNION ALL SELECT 35 UNION ALL SELECT 36 UNION ALL SELECT 37 UNION ALL SELECT 38\n    UNION ALL SELECT 39 UNION ALL SELECT 40 UNION ALL SELECT 41 UNION ALL SELECT 42\n    UNION ALL SELECT 43 UNION ALL SELECT 44 UNION ALL SELECT 45 UNION ALL SELECT 46\n    UNION ALL SELECT 47 UNION ALL SELECT 48 UNION ALL SELECT 49 UNION ALL SELECT 50\n    UNION ALL SELECT 51 UNION ALL SELECT 52\n)\nSELECT @SQL = @SQL + N'\nUNION ALL SELECT Year, ''Week'' + CAST(n AS NVARCHAR(3)), [Week' + CAST(n AS NVARCHAR(3)) + '] \nFROM YourTable \nFROM Numbers';\n\nEXEC sp_executesql @SQL;