CREATE VIEW CustomerWrapper AS\nSELECT \n    CustomerID,\n    Name,\n    Address,\n    Phone,\n    Email,\n    -- Computed column example\n    OrderTotal = (SELECT SUM(OrderAmount) FROM Orders WHERE CustomerID = c.CustomerID)\nFROM \n    Customers c;