DECLARE @datePart VARCHAR(2)\nDECLARE @dateParameter INT\nDECLARE @sql NVARCHAR(MAX)\n\nSELECT @datePart = 'dd'\nSELECT @dateParameter = 28\n\nSET @sql = N'SELECT * FROM MyTable WHERE DATEDIFF(' + QUOTENAME(@datePart, '''') \n           + N', MyTable.MyDate, GETDATE()) < ' + CAST(@dateParameter AS NVARCHAR(10))\n\nEXEC sp_executesql @sql