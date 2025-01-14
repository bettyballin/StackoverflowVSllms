WITH CombinedData AS (\n    SELECT VisitingCount, [Time]\n    FROM #Temp\n    UNION ALL\n    SELECT COUNT(page) AS VisitingCount,\n           (DATEPART(hour, [Date]) * 60 + DATEPART(minute, [Date])) / 30 AS [Time]\n    FROM scr_SecuristLog\n    WHERE [Date] BETWEEN '2009-05-04 10:30' AND '2009-05-04 12:30'\n    GROUP BY (DATEPART(hour, [Date]) * 60 + DATEPART(minute, [Date])) / 30\n),\nFilteredData AS (\n    SELECT SUM(VisitingCount) AS VisitingCount,\n           [Time],\n           ROW_NUMBER() OVER (PARTITION BY [Time] ORDER BY VisitingCount DESC) as rn\n    FROM CombinedData\n    GROUP BY [Time]\n)\nSELECT VisitingCount, [Time]\nFROM FilteredData\nWHERE rn = 1\nORDER BY [Time];