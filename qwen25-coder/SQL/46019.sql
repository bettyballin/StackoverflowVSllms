-- Assume @StartDate and @EndDate are provided as parameters or variables with the range you need.\nWITH DateSeries AS (\n    SELECT CAST(@StartDate AS DATE) AS currentDate\n    UNION ALL\n    SELECT DATEADD(DAY, 1, currentDate)\n    FROM DateSeries\n    WHERE currentDate < @EndDate\n),\nAvailableBoards AS (\n    SELECT \n        ds.currentDate,\n        COUNT(bb.IdBillboard) AS AvailableCount\n    FROM \n        DateSeries ds\n    LEFT JOIN \n        tBillboards bb ON (bb.StartDate IS NULL OR bb.StartDate <= ds.currentDate)\n                       AND (bb.FinishDate IS NULL OR bb.FinishDate >= DATEADD(DAY, 1, ds.currentDate))\n    GROUP BY \n        ds.currentDate\n)\nSELECT SUM(AvailableCount) AS TotalAvailableBoardsInPeriod\nFROM \n    AvailableBoards;