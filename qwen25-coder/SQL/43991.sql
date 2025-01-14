CREATE PROCEDURE getEmployees \n    @SortColumn varchar(100),\n    @SortDirection varchar(4) = 'ASC'  -- Default to ascending if not specified\nAS\nBEGIN\n    DECLARE @SQL nvarchar(MAX)\n\n    SET @SQL = N'SELECT EmployeeID, FirstName, LastName, SSN, Salary FROM Employees ORDER BY ' + QUOTENAME(@SortColumn)\n\n    IF UPPER(@SortDirection) IN ('ASC', 'DESC')\n    BEGIN\n        SET @SQL += N' ' + UPPER(@SortDirection)\n    END\n    ELSE\n    BEGIN\n        RAISERROR('Invalid sort direction. Must be ASC or DESC.', 16, 1)\n        RETURN\n    END\n\n    EXEC sp_executesql @SQL\nEND