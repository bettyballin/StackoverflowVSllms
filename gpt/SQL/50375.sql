WITH MostRecentAddress AS (\n    SELECT \n        a.CustomerID,\n        a.State,\n        ROW_NUMBER() OVER (PARTITION BY a.CustomerID ORDER BY a.AddressID DESC) AS rn\n    FROM \n        Address a\n)\nSELECT \n    mra.State,\n    COUNT(DISTINCT c.CustomerID) AS NumberOfCustomers\nFROM \n    Product p\n    INNER JOIN Customer c ON c.CustomerID = p.CustomerID\n    INNER JOIN MostRecentAddress mra ON mra.CustomerID = c.CustomerID AND mra.rn = 1\nWHERE \n    p.ProductID = 101\nGROUP BY \n    mra.State\nORDER BY \n    mra.State;