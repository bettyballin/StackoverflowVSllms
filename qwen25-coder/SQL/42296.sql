SELECT \n    m.SalesManCode,\n    MAX(CASE WHEN MONTH(mt.SaleDate) = 1 THEN mt.TargetValue END) AS JanTar,\n    MAX(CASE WHEN MONTH(ms.SaleDate) = 1 THEN ms.AchievedValue END) AS JanAch,\n    MAX(CASE WHEN MONTH(mt.SaleDate) = 2 THEN mt.TargetValue END) AS FebTar,\n    MAX(CASE WHEN MONTH(ms.SaleDate) = 2 THEN ms.AchievedValue END) AS FebAch,\n    -- Repeat for each month up to December\n    MAX(CASE WHEN MONTH(mt.SaleDate) = 12 THEN mt.TargetValue END) AS DecTar,\n    MAX(CASE WHEN MONTH(ms.SaleDate) = 12 THEN ms.AchievedValue END) AS DecAch\nFROM \n    MonthlyTarget mt\nJOIN \n    MonthlySales ms ON m.SalesManCode = ms.SalesManCode AND YEAR(mt.SaleDate) = YEAR(ms.SaleDate)\nGROUP BY \n    m.SalesManCode;