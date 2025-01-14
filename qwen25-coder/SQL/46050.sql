-- Create a table variable or temp table to store results if needed\nDECLARE @Results TABLE (\n    -- Define the columns based on the structure of your inline function result set\n    Column1 INT, \n    Column2 NVARCHAR(100)\n);\n\nINSERT INTO @Results (Column1, Column2)  -- Adjust column names and types as per your test_1 output\nSELECT t.*\nFROM kp kp\nCROSS APPLY (\n    SELECT dbo.test_2(kp.id) AS inputValue\n) AS scalarResult\nCROSS APPLY MM.test_1(scalarResult.inputValue) t;\n\n-- Select from the results if you stored them in a table variable\nSELECT * FROM @Results;