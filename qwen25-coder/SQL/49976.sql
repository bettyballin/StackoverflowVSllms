-- Creating a temporary table\nCREATE TABLE #TempTable (\n    ID INT PRIMARY KEY,\n    Name NVARCHAR(100),\n    Data NVARCHAR(MAX)\n);\n\n-- Inserting data into the temporary table\nINSERT INTO #TempTable (ID, Name, Data)\nVALUES (1, 'Sample', 'Some sample data');\n\n-- Querying the temporary table\nSELECT * FROM #TempTable;\n\n-- Dropping the temporary table when done\nDROP TABLE #TempTable;