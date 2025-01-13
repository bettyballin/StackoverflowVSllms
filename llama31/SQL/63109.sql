SELECT \n  mt.SalesManCode,\n  SUM(CASE WHEN mt.TargetMonthYear = 'Jan' THEN mt.TargetValue END) AS JanTar,\n  SUM(CASE WHEN ms.SaleDate = 'Jan' THEN ms.AchievedValue END) AS JanAch,\n  ...\n  SUM(CASE WHEN mt.TargetMonthYear = 'Dec' THEN mt.TargetValue END) AS DecTar,\n  SUM(CASE WHEN ms.SaleDate = 'Dec' THEN ms.AchievedValue END) AS DecAch\nFROM \n  (SELECT DISTINCT SalesManCode FROM MonthlyTarget) mt\n  LEFT JOIN (\n    SELECT \n      SalesManCode,\n      SaleDate,\n      AchievedValue\n    FROM \n      MonthlySales\n  ) ms ON mt.SalesManCode = ms.SalesManCode\nGROUP BY \n  mt.SalesManCode