CREATE PROCEDURE GenerateEmployeeSalesPivot\nAS\nBEGIN\n    DECLARE @EmployeeIDs NVARCHAR(MAX)\n    DECLARE @SQL NVARCHAR(MAX)\n\n    -- Step 1: Retrieve the distinct employee IDs and construct the IN clause\n    SELECT @EmployeeIDs = STRING_AGG(QUOTENAME(EmployeeID), ',')\n    FROM Employees\n\n    -- Step 2: Construct the dynamic SQL for the pivot query\n    SET @SQL = '\n        SELECT *\n        FROM (\n            SELECT EmployeeID, SaleAmount, SaleDate\n            FROM Sales\n        ) src\n        PIVOT (\n            SUM(SaleAmount)\n            FOR EmployeeID IN (' + @EmployeeIDs + ')\n        ) pvt;\n    '\n\n    -- Step 3: Execute the dynamic SQL\n    EXEC sp_executesql @SQL\nEND