SELECT Customers.CustomerID, Customers.Name, Orders.OrderID, Orders.OrderDate\nFROM Orders\nRIGHT OUTER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;