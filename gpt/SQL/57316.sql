DECLARE @BatchSize INT = 1000;\n   DECLARE @Offset INT = 0;\n\n   WHILE (@Offset < (SELECT COUNT(*) FROM #TempIDs))\n   BEGIN\n       WITH CTE AS (\n           SELECT ID\n           FROM #TempIDs\n           ORDER BY ID\n           OFFSET @Offset ROWS FETCH NEXT @BatchSize ROWS ONLY\n       )\n       UPDATE t\n       SET t.Property = 'NewValue'\n       FROM TargetTable t\n       INNER JOIN CTE temp ON t.ID = temp.ID;\n\n       SET @Offset = @Offset + @BatchSize;\n   END;