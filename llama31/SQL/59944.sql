-- Create a new SSIS package\nCREATE PACKAGE TransferData\nAS\nBEGIN\n    -- Call the ValidateData stored procedure\n    EXEC ValidateData\n\n    -- Transfer the validated data\n    INSERT INTO ProductionTable (ID, Field1, Field2)\n    SELECT ID, Field1, Field2\n    FROM #ValidData\n\n    -- Replace existing records in the production table\n    UPDATE p\n    SET p.Field1 = s.Field1, p.Field2 = s.Field2\n    FROM ProductionTable p\n    INNER JOIN StagingTable s ON p.ID = s.ID\n\n    RETURN\nEND