DECLARE @RowIdMin INT = 10\nDECLARE @RowIdMax INT = 25\nDECLARE @ColSort NVARCHAR(100) = 'MyColumn'\nDECLARE @SQL NVARCHAR(MAX)\n\nSET @SQL = '\n    SELECT * \n    FROM (\n        SELECT Col1, Col2, ROW_NUMBER() OVER (ORDER BY ' + QUOTENAME(@ColSort) + ' DESC) AS RowId \n        FROM MyTable\n    ) dt \n    WHERE RowId BETWEEN @RowIdMin AND @RowIdMax'\n\nEXEC sp_executesql @SQL, N'@RowIdMin INT, @RowIdMax INT', @RowIdMin, @RowIdMax