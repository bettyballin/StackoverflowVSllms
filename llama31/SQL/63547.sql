UPDATE c\nSET c.UnownedProduct = p.ProductName\nFROM Customers c\nCROSS APPLY (\n  SELECT TOP 1 p.ProductName\n  FROM Products p\n  WHERE NOT EXISTS (\n    SELECT 1\n    FROM CustomerProducts cp\n    WHERE cp.CustomerID = c.CustomerID AND cp.ProductID = p.ProductID\n  )\n) p\nWHERE c.CustomerID = (\n  SELECT TOP 1 c.CustomerID\n  FROM Customers c\n  WHERE NOT EXISTS (\n    SELECT 1\n    FROM CustomerProducts cp\n    WHERE cp.CustomerID = c.CustomerID AND cp.ProductID = p.ProductID\n  )\n)