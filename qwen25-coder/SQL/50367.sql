SELECT Customers.Name, Orders.OrderDate\nFROM Customers\nINNER JOIN Orders ON Customers.ID = Orders.CustomerID\nWHERE Customers.City = 'New York'\nORDER BY Orders.OrderDate;