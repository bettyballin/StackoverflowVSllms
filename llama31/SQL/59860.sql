CREATE PROCEDURE DequeueMessage\nAS\nBEGIN\n    BEGIN TRANSACTION;\n\n    DECLARE @Id INT;\n    DECLARE @DataId INT;\n\n    SELECT TOP 1 @Id = Id, @DataId = DataId\n    FROM MessageQueue\n    WHERE Status = 'NEW'\n    ORDER BY Id;\n\n    IF @@ROWCOUNT = 0\n    BEGIN\n        ROLLBACK TRANSACTION;\n        RETURN;\n    END\n\n    UPDATE MessageQueue\n    SET Status = 'PROCESSING'\n    WHERE Id = @Id;\n\n    COMMIT TRANSACTION;\n\n    SELECT @DataId;  -- return the dequeued message\nEND;