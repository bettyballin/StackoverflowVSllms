-- Stored Procedure\nCreate PROCEDURE MyProcedure \n    @TableName varchar(100), \n    @FieldName varchar(100), \n    @Data TABLE (FieldValue varchar(100)) OUTPUT\nAS\nBEGIN\n    DECLARE @SQL NVARCHAR(MAX)\n    SET @SQL = 'INSERT INTO @Data SELECT '+ QUOTENAME(@FieldName) + ' FROM ' + QUOTENAME(@TableName)\n\n    EXEC sp_executesql @SQL, N'@Data TABLE (FieldValue varchar(100)) OUTPUT', @Data=@Data OUTPUT\nEND\n\n-- Using the Stored Procedure within another procedure or batch\nDECLARE @MyData TABLE (FieldValue varchar(100))\nEXEC MyProcedure 'Person.Address', 'AddressID', @MyData OUTPUT\n\n-- Selecting from the table variable to verify results\nSELECT * FROM @MyData