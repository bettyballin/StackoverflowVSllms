-- Normalized database: Using JOINs\nSELECT Orders.OrderID, Customers.CustomerName, OrderDetails.ProductID, Products.ProductName\nFROM Orders\nJOIN Customers ON Orders.CustomerID = Customers.CustomerID\nJOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID\nJOIN Products ON OrderDetails.ProductID = Products.ProductID;\n\n-- Denormalized database: Single table with redundant data\nSELECT OrderID, CustomerName, ProductID, ProductName\nFROM CombinedOrders;