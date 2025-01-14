DECLARE @BatchSize INT = 1000;\nDECLARE @FirstRow INT = 1;\n\nWHILE 1=1\nBEGIN\n    BEGIN TRANSACTION;\n\n    -- Update related table in batches\n    UPDATE TOP (@BatchSize) TableToUpdate\n    SET UserNo = @userToKeep\n    WHERE UserNo = @userToDiscard AND ID >= @FirstRow;\n\n    -- DELETE user preferences in batches\n    DELETE TOP (@BatchSize) FROM UserPreferences\n    WHERE UserNo = @userToDiscard AND ID >= @FirstRow;\n\n    COMMIT TRANSACTION;\n\n    -- Update to the next batch\n    SET @FirstRow += @BatchSize;\n\n    -- Exit condition: no more rows to process\n    IF @@ROWCOUNT < @BatchSize BREAK;\nEND;\n\n-- Final Delete user record after all references are updated and their preferences deleted\nBEGIN TRANSACTION;\nDELETE FROM Users WHERE UserNo = @userToDiscard;\nCOMMIT TRANSACTION;