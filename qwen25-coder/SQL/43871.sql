DECLARE @tableName NVARCHAR(100)\nDECLARE @query NVARCHAR(MAX)\n\n-- Find the actual name of your temporary table in tempdb\nSELECT TOP 1 @tableName = NAME \nFROM tempdb.sys.tables \nWHERE Name LIKE '#Return_Records%'\n\n-- Construct and execute a dynamic SQL query to select data from the found table\nSET @query = N'SELECT * FROM ' + QUOTENAME(@tableName, '[') \n\nEXEC sp_executesql @query