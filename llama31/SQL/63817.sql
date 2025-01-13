DECLARE @MoreExists BIT;\nDECLARE @TopN INT = 50;\n\nWITH Results AS (\n    SELECT TOP (@TopN + 1) -- Select one more than needed to check for more\n        Field1,\n        Field2,\n        -- ... other fields\n    FROM\n        MyTable\n    WHERE\n        -- some expensive where clause\n    ORDER BY\n        -- some order by clause if needed\n)\nSELECT \n    @MoreExists = CASE WHEN COUNT(*) > @TopN THEN 1 ELSE 0 END\nFROM \n    Results;\n\n-- Now select the top N results\nSELECT TOP (@TopN)\n    Field1,\n    Field2,\n    -- ... other fields\nFROM \n    Results;\n\n-- @MoreExists now indicates if more results would have been returned.\nSELECT @MoreExists AS MoreExists;