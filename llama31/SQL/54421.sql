SELECT CustomerID, OrderDate, COUNT(1) Cnt\nFROM Sales.SalesOrderHeader\nWHERE CustomerID = 11300\nGROUP BY CustomerID, OrderDate\nHAVING COUNT(1) = (\n  SELECT MAX(Cnt)\n  FROM (\n    SELECT COUNT(1) Cnt\n    FROM Sales.SalesOrderHeader\n    WHERE CustomerID = 11300\n    GROUP BY CustomerID, OrderDate\n  ) subquery\n)