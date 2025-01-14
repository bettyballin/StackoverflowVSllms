-- Create a temporary table to store the results of the query\nCREATE TABLE #TempTable (\n    ID INT PRIMARY KEY,\n    Column1 NVARCHAR(100),\n    Column2 NVARCHAR(100)\n);\n\n-- Insert data into the temporary table\nINSERT INTO #TempTable (ID, Column1, Column2)\nSELECT ID, Column1, Column2\nFROM YourTable\nWHERE YourCondition;\n\n-- Loop through the temporary table\nDECLARE @CurrentID INT;\nDECLARE @MaxID INT;\n\n-- Get the range of IDs\nSELECT @CurrentID = MIN(ID), @MaxID = MAX(ID) FROM #TempTable;\n\nWHILE @CurrentID <= @MaxID\nBEGIN\n    -- Process each row\n    SELECT Column1, Column2\n    FROM #TempTable\n    WHERE ID = @CurrentID;\n\n    -- Increment the ID\n    SET @CurrentID = @CurrentID + 1;\nEND;\n\n-- Drop the temporary table\nDROP TABLE #TempTable;