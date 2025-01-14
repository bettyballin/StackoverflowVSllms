WITH DateDifferences AS (\n    SELECT \n        ID,\n        REF,\n        Date,\n        LAG(Date) OVER (PARTITION BY ID, REF ORDER BY Date) AS PreviousDate,\n        DATEDIFF(day, LAG(Date) OVER (PARTITION BY ID, REF ORDER BY Date), Date) AS DaysDiff\n    FROM Transactions\n)\nSELECT \n    ID,\n    REF,\n    AVG(DaysDiff) AS Avg_Days\nFROM DateDifferences\nWHERE DaysDiff IS NOT NULL\nGROUP BY ID, REF;