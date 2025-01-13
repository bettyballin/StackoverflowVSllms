-- Create a temporary table with an identity column\nCREATE TABLE #TempTable (\n    ID INT IDENTITY(1,1),\n    Column1 INT,\n    Column2 VARCHAR(100)\n    -- Add other columns as needed\n)\n\n-- Insert data into temporary table\nINSERT INTO #TempTable (Column1, Column2)\nSELECT Column1, Column2\nFROM YourTable\nORDER BY SomeColumn\n\n-- Select from the temporary table including the incremental ID\nSELECT ID AS IncrementalColumn, Column1, Column2\nFROM #TempTable\nORDER BY SomeColumn\n\n-- Drop the temporary table\nDROP TABLE #TempTable