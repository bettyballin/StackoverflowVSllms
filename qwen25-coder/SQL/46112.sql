DECLARE @db_name sysname;\nSELECT @db_name = DB_Name FROM ##temp;\n\n-- Use dynamic SQL to switch databases\nDECLARE @sql NVARCHAR(MAX);\nSET @sql = N'USE ' + QUOTENAME(@db_name) + '; INSERT INTO [dbo].[ProjectVersion] ([DB_Name], [Script]) VALUES (@db_name, ''1.2'');';\nEXEC sp_executesql @sql, N'@db_name sysname', @db_name;