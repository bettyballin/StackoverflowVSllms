WITH WeeklySales AS (\n    SELECT \n        Branch,\n        DATEPART(WEEK, DateOfSale) AS SaleWeek,\n        YEAR(DateOfSale) AS SaleYear,\n        SUM(CASE WHEN DATEPART(WEEKDAY, DateOfSale) = 3 THEN SalesAmount ELSE 0 END) AS DailySales, -- Assuming Wednesday as the target day for daily comparison\n        SUM(SalesAmount) AS WTD\n    FROM\n        Sales\n    WHERE \n        DateOfSale >= DATEADD(DAY, -14, '2009-07-16') AND DateOfSale < '2009-07-16'\n    GROUP BY \n        Branch,\n        DATEPART(WEEK, DateOfSale),\n        YEAR(DateOfSale)\n),\nPreviousYearSales AS (\n    SELECT \n        bs.Branch,\n        bs.SaleWeek,\n        bs.DailySales AS LastYearDailySales,\n        bs.WTD AS LastYearWTD\n    FROM\n        WeeklySales bs\n    WHERE \n        bs.SaleYear = YEAR(DATEADD(YEAR, -1, '2009-07-16'))\n),\nPreviousWeekSales AS (\n    SELECT \n        ws.Branch,\n        SUM(CASE WHEN DATEPART(WEEKDAY, ws.DateOfSale) = 3 THEN ws.SalesAmount ELSE 0 END) AS LastWeekDailySales, -- Assuming Wednesday as the target day for daily comparison\n        SUM(ws.SalesAmount) AS LastWeekWTD\n    FROM \n        Sales ws\n    WHERE \n        ws.DateOfSale >= DATEADD(WEEK, -1, '2009-07-16') AND ws.DateOfSale < DATEADD(DAY, -7, '2009-07-16')\n    GROUP BY  \n        ws.Branch\n)\nSELECT \n    ws.Branch,\n    ws.DailySales,\n    COALESCE(lys.LastYearDailySales, pws.LastWeekDailySales) AS DailyLFL,\n    ws.WTD,\n    COALESCE(lys.LastYearWTD, pws.LastWeekWTD) AS WTDLFL,\n    CASE \n        WHEN lys.LastYearDailySales IS NOT NULL THEN 'Y'\n        ELSE 'N'\n    END AS LFL\nFROM \n    WeeklySales ws\nLEFT JOIN \n    PreviousYearSales lys ON ws.Branch = lys.Branch AND ws.SaleWeek = lys.SaleWeek\nLEFT JOIN \n    PreviousWeekSales pws ON ws.Branch = pws.Branch;