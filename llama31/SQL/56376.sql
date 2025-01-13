CREATE TRIGGER trg_Delete ON YourTable\nFOR DELETE\nAS\nBEGIN\n    DECLARE @CurrentUser uniqueidentifier\n    SET @CurrentUser = SUSER_ID()\n\n    -- or use SUSER_SNAME() to get the username\n    DECLARE @CurrentUsername nvarchar(256)\n    SET @CurrentUsername = SUSER_SNAME()\n\n    -- log the user's ID or name along with the deleted data\n    INSERT INTO YourAuditTable (DeletedData, DeletedBy, DeletedDate)\n    SELECT d.*, @CurrentUser, GETDATE()\n    FROM deleted d\nEND