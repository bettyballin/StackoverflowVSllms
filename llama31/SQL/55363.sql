SELECT \n  c.CustomerName,\n  MAX(CASE WHEN p.ProductID = (SELECT MIN(ProductID) FROM Products WHERE CustomerID = c.CustomerID) THEN p.ProductName END) AS Product1Name,\n  MAX(CASE WHEN p.ProductID = (SELECT MAX(ProductID) FROM Products WHERE CustomerID = c.CustomerID) THEN p.ProductName END) AS Product2Name\nFROM \n  Customers c\n  LEFT JOIN Products p ON c.CustomerID = p.CustomerID\nGROUP BY \n  c.CustomerName