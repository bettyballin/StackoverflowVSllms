-- Step 1: Create a temporary table\nCREATE TABLE #TempData (\n    FieldName VARCHAR(50),\n    Value INT\n);\n\n-- Step 2: Insert data into the temporary table\nINSERT INTO #TempData (FieldName, Value)\nVALUES ('Field1', 1), ('Field2', 2), ('Field3', 3);\n\n-- Step 3: Insert from the temp table into the actual table\nINSERT INTO YourTargetTable (Field1, Field2, Field3)\nSELECT\n    MAX(CASE WHEN FieldName = 'Field1' THEN Value END) AS Field1,\n    MAX(CASE WHEN FieldName = 'Field2' THEN Value END) AS Field2,\n    MAX(CASE WHEN FieldName = 'Field3' THEN Value END) AS Field3\nFROM #TempData;\n\n-- Clean up the temporary table\nDROP TABLE #TempData;