WITH RecentOrders AS (\n  SELECT Customer, OrderTotal, \n         ROW_NUMBER() OVER (PARTITION BY Customer ORDER BY OrderDate DESC) AS RowNum\n  FROM Orders\n)\nSELECT Customer, AVG(OrderTotal) AS AvgRecentOrderTotal\nFROM RecentOrders\nWHERE RowNum <= 2\nGROUP BY Customer;