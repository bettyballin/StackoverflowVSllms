BEGIN TRAN\n\n-- Create temporary table\nCREATE TABLE TempTable (c1 INT NULL)\n\nIF @@ERROR <> 0\nBEGIN\n    PRINT 'Error creating table'\n    ROLLBACK TRAN\nEND\nELSE\nBEGIN\n    -- Insert first value\n    INSERT INTO TempTable (c1) SELECT 1\n\n    IF @@ERROR <> 0\n    BEGIN\n        PRINT 'First insert error'\n        ROLLBACK TRAN\n    END\n    ELSE\n    BEGIN\n        -- Attempt second insert, which will cause an error\n        INSERT INTO TempTable (c1) SELECT 'ABS'\n\n        IF @@ERROR <> 0\n        BEGIN\n            PRINT 'Second insert error'\n            ROLLBACK TRAN\n        END\n        ELSE\n        BEGIN\n            PRINT 'no error'\n            COMMIT TRAN\n        END\n    END\nEND