-- Create a temp table to hold the result structure\nCREATE TABLE #TempResults (\n    Column1 DataType,\n    Column2 DataType,\n    -- add other columns as per your stored procedures' results\n);\n\n-- Insert results from the first stored procedure into the temp table\nINSERT INTO #TempResults (Column1, Column2)\nEXEC StoreProcedure1 @p1;\n\n-- Insert results from the second stored procedure into the temp table\nINSERT INTO #TempResults (Column1, Column2)\nEXEC StoreProcedure2 @p2;\n\n-- Select and union the data from the temp table if needed, or just select for your use case\nSELECT * FROM #TempResults;\n\n-- Drop the temp table when done\nDROP TABLE #TempResults;