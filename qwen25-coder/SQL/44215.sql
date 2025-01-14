-- Create a temporary table with the same structure as the output from MyStoredProcedure\nCREATE TABLE #TempResults (\n    ID INT,\n    Name NVARCHAR(255),\n    Descriptions NVARCHAR(MAX)\n);\n\n-- Insert the results of the stored procedure into the temporary table\nINSERT INTO #TempResults (ID, Name, Descriptions)\nEXEC MyStoredProcedure;\n\n-- Count the number of rows in the temporary table\nSELECT COUNT(*) AS ResultCount\nFROM #TempResults;\n\n-- Clean up the temporary table\nDROP TABLE #TempResults;