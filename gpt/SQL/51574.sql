CREATE TABLE #Temp (VisitingCount int, [Time] int);\nDECLARE @DateNow DATETIME, @i int, @Time int;\nSET @DateNow = '00:00';\nSET @i = 1;\nWHILE (@i < 48)\nBEGIN\n    SET @DateNow = DATEADD(minute, 30, @DateNow);\n    SET @Time = (DATEPART(hour, @DateNow) * 60 + DATEPART(minute, @DateNow)) / 30;\n    INSERT INTO #Temp (VisitingCount, [Time]) VALUES (0, @Time);\n    SET @i = @i + 1;\nEND;\n\nWITH CombinedData AS (\n    SELECT SUM(VisitingCount) AS VisitingCount, [Time]\n    FROM #Temp\n    GROUP BY [Time]\n    UNION ALL\n    SELECT COUNT(page) AS VisitingCount,\n           (DATEPART(hour, Date) * 60 + DATEPART(minute, Date)) / 30 AS [Time]\n    FROM scr_SecuristLog\n    WHERE Date BETWEEN '2009-05-04 10:30' AND '2009-05-04 12:30'\n    GROUP BY (DATEPART(hour, Date) * 60 + DATEPART(minute, Date)) / 30\n)\nSELECT MAX(VisitingCount) AS VisitingCount, [Time]\nFROM CombinedData\nGROUP BY [Time]\nORDER BY [Time] ASC;