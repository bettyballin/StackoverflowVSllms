-- Get column names from system table\nDECLARE @phCols NVARCHAR(2000)\nSELECT @phCols = COALESCE(@phCols + ',[' + name + ']', '[' + name + ']') \n    FROM syscolumns WHERE id = (select id from sysobjects where name = 'Test' and type='U')\n\n-- Get rid of the column we don't want\nSELECT @phCols = REPLACE(@phCols, '[Timestamp],', '')\n\n-- Query & sum using the dynamic column names\nDECLARE @exec nvarchar(2000)\nSELECT @exec =\n'\n    select\n        SUBSTRING([Value], 2, LEN([Value]) - 1) as [Index],\n        SUM(CASE WHEN (LEFT([Value], 1) = ''A'') THEN Cols ELSE 0 END) as AValue, \n        SUM(CASE WHEN (LEFT([Value], 1) = ''B'') THEN Cols ELSE 0 END) as BValue\n    FROM\n    (\n        select *\n        from (select ' + @phCols + ' from Test) as t\n        unpivot (Cols FOR [Value] in (' + @phCols + ')) as p\n    ) _temp\n    GROUP BY SUBSTRING([Value], 2, LEN([Value]) - 1)\n'\nEXECUTE(@exec)