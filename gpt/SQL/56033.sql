SELECT TOP 1 [ColumnName]\nFROM (\n    SELECT [ColumnName], ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNum\n    FROM [SheetName$]\n) AS TempTable\nWHERE RowNum = RowIndex;