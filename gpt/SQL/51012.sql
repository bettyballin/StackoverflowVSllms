-- Create a temporary table to hold the pivoted data\nCREATE TABLE #PivotedData (\n    ID INT,\n    Type10 INT,\n    Type14 INT,\n    Type25 INT\n);\n\n-- Insert data into the temporary table using conditional aggregation\nINSERT INTO #PivotedData (ID, Type10, Type14, Type25)\nSELECT \n    ID,\n    MAX(CASE WHEN Type = 10 THEN Value ELSE NULL END) AS Type10,\n    MAX(CASE WHEN Type = 14 THEN Value ELSE NULL END) AS Type14,\n    MAX(CASE WHEN Type = 25 THEN Value ELSE NULL END) AS Type25\nFROM VerticalTable\nGROUP BY ID;\n\n-- Select data from the temporary table\nSELECT * FROM #PivotedData;