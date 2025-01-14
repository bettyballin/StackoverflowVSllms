WITH OrderCount AS (\n    SELECT \n        CustomerID,\n        OrderDate,\n        COUNT(1) as Cnt\n    FROM Sales.SalesOrderHeader\n    WHERE CustomerID = 11300\n    GROUP BY CustomerID, OrderDate\n)\nSELECT \n    CustomerID,\n    OrderDate,\n    Cnt\nFROM OrderCount\nWHERE Cnt = (\n    SELECT MAX(Cnt)\n    FROM OrderCount\n);