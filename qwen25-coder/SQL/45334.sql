CREATE PROCEDURE MyProc\n    (@TableName varchar(255),\n     @FirstName varchar(50),\n     @LastName varchar(50))\n  AS\n  BEGIN\n      DECLARE @SQLStatement NVARCHAR(MAX)\n\n      SET @SQLStatement = N'SELECT * FROM ' + QUOTENAME(@TableName) + \n                          N' WHERE FirstName = @FirstName AND LastName = @LastName';\n\n      EXEC sp_executesql @SQLStatement, \n                         N'@FirstName varchar(50), @LastName varchar(50)', \n                         @FirstName, @LastName;\n  END