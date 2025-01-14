SELECT COALESCE(SUM(Price), 0) AS TotalPrice \nFROM Inventory\nWHERE (DateAdded BETWEEN @StartDate AND @EndDate)