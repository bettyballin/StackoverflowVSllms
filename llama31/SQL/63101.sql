WITH SalesData AS (\n  SELECT \n    mt.SalesManCode,\n    mt.TargetMonthYear,\n    mt.TargetValue,\n    ms.AchievedValue\n  FROM \n    MonthlyTarget mt\n    LEFT JOIN MonthlySales ms ON mt.SalesManCode = ms.SalesManCode\n)\nSELECT \n  SalesManCode,\n  SUM(CASE WHEN TargetMonthYear = 'Jan' THEN TargetValue END) AS JanTar,\n  SUM(CASE WHEN SaleDate = 'Jan' THEN AchievedValue END) AS JanAch,\n  ...\n  SUM(CASE WHEN TargetMonthYear = 'Dec' THEN TargetValue END) AS DecTar,\n  SUM(CASE WHEN SaleDate = 'Dec' THEN AchievedValue END) AS DecAch\nFROM \n  SalesData\nGROUP BY \n  SalesManCode