SELECT DISTINCT CustomerID\nFROM TableName\nWHERE DATE(OrderDate) = CURDATE();