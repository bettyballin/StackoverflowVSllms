CREATE PROCEDURE spStats_GetSalesStatsByHour\n    @ShopId int\nAS\nBEGIN\n    SELECT     \n        DATEADD(dd, 0, DATEDIFF(dd, 0, TableA.Created)) AS Day, \n        DATEPART(hh, TableA.Created) AS [Hour], \n        SUM(TableB.Quantity) AS Quantity, \n        SUM(TableB.Amount) AS Amount\n    FROM\n        TableA\n        INNER JOIN TableB WITH (INDEX(ID)) ON TableA.BID = TableB.ID\n    WHERE     \n        (TableA.ShopId = @ShopId)\n    GROUP BY \n        DATEADD(dd, 0, DATEDIFF(dd, 0, TableA.Created)), \n        DATEPART(hh, TableA.Created)\n    ORDER BY \n        DATEPART(hh, TableA.Created)\nEND