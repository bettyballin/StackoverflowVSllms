DECLARE @SQL NVARCHAR(MAX)\nDECLARE @ClientType VARCHAR(10) = 'Employee' -- Example value\nDECLARE @Source VARCHAR(10)\n\nIF @ClientType = 'Employee'\n    SET @Source = 'HR'\nELSE IF @ClientType = 'Member'\n    SET @Source = 'Other'\n\nSET @SQL = 'SELECT Md5 FROM ' + QUOTENAME(@Source) + ' WHERE Current = 2'\n\nEXEC sp_executesql @SQL