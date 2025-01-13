SELECT \n    s.SupplierID, \n    SUM(CASE WHEN t.TableName = 'Computers' THEN 1 ELSE 0 END) AS Computers,\n    SUM(CASE WHEN t.TableName = 'Cameras' THEN 1 ELSE 0 END) AS Cameras,\n    SUM(CASE WHEN t.TableName = 'Displays' THEN 1 ELSE 0 END) AS Displays\nFROM \n    Supplier s\nLEFT JOIN \n    (\n        SELECT SupplierID, 'Computers' AS TableName FROM Computers\n        UNION ALL\n        SELECT SupplierID, 'Cameras' AS TableName FROM Cameras\n        UNION ALL\n        SELECT SupplierID, 'Displays' AS TableName FROM Displays\n    ) t\n    ON s.SupplierID = t.SupplierID\nGROUP BY \n    s.SupplierID