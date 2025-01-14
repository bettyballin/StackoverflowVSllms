CREATE VIEW vw_OrderDetails\nAS\nSELECT \n    o.OrderID,\n    o.OrderDate,\n    c.CustomerName,\n    p.ProductName,\n    od.Quantity,\n    od.UnitPrice\nFROM \n    Orders o\nJOIN \n    OrderDetails od ON o.OrderID = od.OrderID\nJOIN \n    Customers c ON o.CustomerID = c.CustomerID\nJOIN \n    Products p ON od.ProductID = p.ProductID;