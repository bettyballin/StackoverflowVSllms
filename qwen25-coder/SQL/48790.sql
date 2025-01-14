CREATE PROCEDURE MyStoredProcedure\nAS\nBEGIN\n    DECLARE @message NVARCHAR(4000);\n    SET @message = N'This is a debug message from inside the procedure.';\n\n    -- Raiserror with severity 0 to log without stopping execution\n    RAISERROR (@message, 0, 1) WITH NOWAIT;\nEND