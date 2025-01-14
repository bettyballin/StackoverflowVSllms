WITH AnimalSales AS (\n    SELECT \n        a.AnimalID, \n        a.Name, \n        a.Category, \n        s.SaleDate, \n        ao.ReceivingDate,\n        DATEDIFF(day, ao.ReceivingDate, s.SaleDate) AS DaysToSell\n    FROM \n        Sale s\n    INNER JOIN SaleAnimal sa ON s.SaleID = sa.SaleID\n    INNER JOIN Animal a ON sa.AnimalID = a.AnimalID\n    INNER JOIN AnimalOrderItem aoi ON a.AnimalID = aoi.AnimalID\n    INNER JOIN AnimalOrder ao ON aoi.OrderID = ao.OrderID\n    WHERE a.Category = 'cat'\n),\nAverageDaysToSell AS (\n    SELECT \n        AVG(DaysToSell) AS AvgDaysToSell\n    FROM \n        AnimalSales\n)\nSELECT \n    AnimalID, \n    Name, \n    Category, \n    DaysToSell\nFROM \n    AnimalSales\nWHERE \n    DaysToSell > (SELECT AvgDaysToSell FROM AverageDaysToSell)\nORDER BY \n    DaysToSell DESC;