DECLARE @chunkSize INT = 10;  -- adjust chunk size according to your needs\n\nWHILE EXISTS (SELECT 1 FROM UserPrefs WHERE UserNo = @userToDiscard)\nBEGIN\n    DELETE TOP (@chunkSize) FROM UserPrefs\n    WHERE UserNo = @userToDiscard;\n\n    COMMIT TRANSACTION;\nEND