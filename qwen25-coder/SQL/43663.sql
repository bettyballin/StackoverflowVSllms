-- Step 1: Create a temporary mapping table\nCREATE TABLE #IDMapping (\n    OldParentId INT,\n    NewParentId INT\n);\n\n-- Step 2: Insert data from Old Table1 to New Table1 and populate the Mapping Table\nINSERT INTO NewTable1 (Name)\nOUTPUT INSERTED.ParentId, SCOPE_IDENTITY() INTO #IDMapping(OldParentId, NewParentId) -- Capture old ParentId and new generated ParentId\nSELECT Name \nFROM OldTable1;\n\n-- Step 3: Insert data from Old Table2 to New Table2 using the Mapping Table\nINSERT INTO NewTable2 (Foo, ParentId)\nSELECT o.Foo, m.NewParentId\nFROM OldTable2 o\nJOIN #IDMapping m ON o.ParentId = m.OldParentId; -- Map old ParentId to new one\n\n-- Step 4: Drop temporary table after use\nDROP TABLE #IDMapping;