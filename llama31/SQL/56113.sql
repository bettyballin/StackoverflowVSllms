-- Create a temporary table\nCREATE TABLE #temp (id INT PRIMARY KEY, value VARCHAR(50));\n\n-- Insert 100,000 rows into the temporary table\nINSERT INTO #temp (id, value)\nSELECT TOP 100000 ROW_NUMBER() OVER (ORDER BY t1.object_id), 'value'\nFROM master.sys.all_columns t1\nCROSS JOIN master.sys.all_columns t2;\n\n-- Measure the time it takes to query the temporary table\nDECLARE @start DATETIME = GETDATE();\nSELECT * FROM #temp;\nPRINT DATEDIFF(MS, @start, GETDATE());\n\n-- Drop the temporary table\nDROP TABLE #temp;\n\n-- Create a physical table\nCREATE TABLE temp (id INT PRIMARY KEY, value VARCHAR(50));\n\n-- Insert 100,000 rows into the physical table\nINSERT INTO temp (id, value)\nSELECT TOP 100000 ROW_NUMBER() OVER (ORDER BY t1.object_id), 'value'\nFROM master.sys.all_columns t1\nCROSS JOIN master.sys.all_columns t2;\n\n-- Measure the time it takes to query the physical table\nDECLARE @start DATETIME = GETDATE();\nSELECT * FROM temp;\nPRINT DATEDIFF(MS, @start, GETDATE());\n\n-- Drop the physical table\nDROP TABLE temp;