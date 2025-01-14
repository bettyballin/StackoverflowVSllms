DECLARE @DynamicPivotQuery AS NVARCHAR(MAX)\nDECLARE @ColumnName AS NVARCHAR(MAX)\n\n-- Get distinct Position names as columns for pivot\nSELECT @ColumnName = COALESCE(@ColumnName + ',[' + PositionName + ']', '[' + PositionName + ']')\nFROM Position\n\n-- Create the dynamic SQL query for Pivot\nSET @DynamicPivotQuery = \n    N'SELECT CID, C.CName, ' + @ColumnName + '\n      FROM (\n        SELECT CP.CPID, CP.CID, P.PositionName, CP.COrder\n        FROM CategoryPosition AS CP\n        INNER JOIN Position AS P ON CP.PID = P.PositionID\n        INNER JOIN Category AS C ON CP.CID = C.CategoryID\n      ) AS SourceTable\n      PIVOT(\n        MAX(COrder)\n        FOR PositionName IN (' + @ColumnName + ')\n      ) AS PivotTable'\n\n-- Execute the dynamic SQL query\nEXEC sp_executesql @DynamicPivotQuery