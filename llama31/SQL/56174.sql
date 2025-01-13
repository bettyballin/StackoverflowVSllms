-- Generate schema script for the "MyDatabase" database\nUSE MyDatabase\nGO\n\n-- Create the database script\nDECLARE @sql nvarchar(max)\nSET @sql = ''\n\n-- Get the database schema\nSELECT @sql += 'CREATE TABLE ' + QUOTENAME(s.name) + '.' + QUOTENAME(t.name) + ' (' + \n               STUFF((SELECT ', ' + QUOTENAME(c.name) + ' ' + QUOTENAME(c.system_type_name)\n                      FROM sys.columns c\n                      WHERE c.object_id = t.object_id\n                      FOR XML PATH(''), TYPE).value('.', 'nvarchar(max)'), 1, 2, '') + '); '\nFROM sys.tables t\nJOIN sys.schemas s ON t.schema_id = s.schema_id\nWHERE t.type = 'U'\n\n-- Print the schema script\nPRINT @sql