-- Helper function to perform specific logic and return data\nCREATE FUNCTION dbo.GetIntermediateData()\nRETURNS @intermediate TABLE (ID INT, ColumnA VARCHAR(100))\nAS\nBEGIN\n    -- Example logic\n    INSERT INTO @intermediate (ID, ColumnA)\n    SELECT ID, ColumnA FROM YourSourceTable;\n    \n    RETURN;\nEND;\n\n-- Main procedure that uses the helper function\nCREATE PROCEDURE dbo.MainProcedure\nAS\nBEGIN\n    DECLARE @temp TABLE (ID INT, ColumnA VARCHAR(100));\n\n    -- Insert results of helper function into temp table\n    INSERT INTO @temp (ID, ColumnA)\n    SELECT ID, ColumnA FROM dbo.GetIntermediateData();\n\n    -- Further processing on the results\n    UPDATE @temp SET ColumnA = 'Processed'\n\n    -- Return final result set\n    SELECT * FROM @temp;\nEND;