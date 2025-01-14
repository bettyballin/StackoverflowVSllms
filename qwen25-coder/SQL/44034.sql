WHILE EXISTS (SELECT 1 FROM updateTable WHERE Processed = 0)\nBEGIN\n    DECLARE @dummyTable TABLE (xmlOutput VARCHAR(2048));\n\n    SELECT TOP 1 @param = record \n    FROM updateTable \n    WHERE Processed = 0;\n\n    INSERT INTO @dummyTable (xmlOutput) \n    EXEC insertSomeData @param;\n\n    -- Assuming there's a column that marks the record as processed\n    UPDATE updateTable \n    SET Processed = 1 \n    WHERE record = @param;\nEND