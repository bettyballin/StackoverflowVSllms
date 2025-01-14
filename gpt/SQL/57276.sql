DECLARE @NthColumn INT = 6;\nDECLARE @RowID INT = 14;\nDECLARE @sql NVARCHAR(MAX);\nDECLARE @columnName NVARCHAR(128);\n\n-- Get the column name for the Nth column\nSELECT @columnName = COLUMN_NAME\nFROM INFORMATION_SCHEMA.COLUMNS\nWHERE TABLE_NAME = 'MyTable'\nAND ORDINAL_POSITION = @NthColumn;\n\n-- Build dynamic SQL query\nSET @sql = N'SELECT ' + QUOTENAME(@columnName) + N' FROM MyTable WHERE RowID = @RowID';\n\n-- Execute dynamic SQL\nEXEC sp_executesql @sql, N'@RowID INT', @RowID;