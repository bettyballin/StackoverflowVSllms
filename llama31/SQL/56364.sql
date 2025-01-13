SELECT ROUND(ISNULL(CAST(SUM(Price) AS DECIMAL(18, 2)), 0), 2) As TotalPrice\nFROM Inventory\nWHERE (DateAdded BETWEEN @StartDate AND @EndDate)