CREATE PROCEDURE GetRecordsByTemplate\n    @template nvarchar(40),\n    @code nvarchar(80)\nAS\nBEGIN\n    DECLARE @sql nvarchar(MAX);\n\n    -- Construct the SQL query dynamically\n    SET @sql = N'SELECT * FROM ' + QUOTENAME(@template) + ' WHERE ProductionCode = @ProductionCode';\n\n    -- Execute the dynamic SQL query\n    EXEC sp_executesql @sql, N'@ProductionCode nvarchar(80)', @ProductionCode = @code;\nEND