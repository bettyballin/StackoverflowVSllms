WITH RankedResults AS (\n    SELECT \n        Field1, \n        Field2, \n        -- Add other fields as needed\n        ROW_NUMBER() OVER (ORDER BY SomeField) AS RowNum,\n        COUNT(*) OVER () AS TotalCount\n    FROM MyTable\n    WHERE ...  -- Your expensive where clause\n)\nSELECT \n    Field1, \n    Field2, \n    -- Add other fields as needed\n    CASE WHEN TotalCount > 50 THEN 1 ELSE 0 END AS MoreExists\nFROM RankedResults\nWHERE RowNum <= 50;