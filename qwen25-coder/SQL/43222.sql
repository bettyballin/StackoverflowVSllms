DECLARE @batchSize INT = 10000;\nDECLARE @rowsAffected INT = @batchSize;\n\nWHILE @rowsAffected = @batchSize\nBEGIN\n    BEGIN TRANSACTION;\n        DELETE TOP (@batchSize) FROM YourTableName\n        -- Optionally, add a WHERE clause if you need to delete specific rows\n    COMMIT TRANSACTION;\n    WAITFOR DELAY '00:00:10';  -- Wait for 10 seconds before the next batch\nEND;