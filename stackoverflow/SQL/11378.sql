SELECT DISTINCT CustomerID\nFROM TableName\n--I assume you want midnight orders as well - so use >=\nWhere OrderDate >= DATEADD(dd, 0, DATEDIFF(dd, 0, GETDATE()))