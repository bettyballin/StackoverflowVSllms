BEGIN TRY\n    BEGIN TRAN\n\n    CREATE TABLE TempTable (c1 INT NULL)\n\n    INSERT INTO TempTable (c1) SELECT 1\n\n    -- This will cause an error\n    INSERT INTO TempTable (c1) SELECT 'ABS'\n\n    COMMIT TRAN\nEND TRY\nBEGIN CATCH\n    PRINT 'error'\n    ROLLBACK TRAN\nEND CATCH