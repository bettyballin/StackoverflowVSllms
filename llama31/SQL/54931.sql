SELECT \n  Title,\n  SUM(CASE WHEN CategoryID = 1 THEN 1 ELSE 0 END) AS Cat1,\n  SUM(CASE WHEN CategoryID = 2 THEN 1 ELSE 0 END) AS Cat2,\n  SUM(CASE WHEN CategoryID IS NULL THEN 1 ELSE 0 END) AS UnknownCategory\nFROM entries\nWHERE Date >= @StartDate AND Date <= @EndDate\nGROUP BY Title