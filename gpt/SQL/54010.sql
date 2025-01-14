CREATE TRIGGER ConnectionLimitTrigger\nON ALL SERVER\nFOR LOGON\nAS\nBEGIN\n    DECLARE @LoginName NVARCHAR(128)\n    DECLARE @SPID INT\n\n    SET @LoginName = ORIGINAL_LOGIN()\n    SET @SPID = @@SPID\n\n    IF @LoginName = 'YourTechnicalAccount'\n    BEGIN\n        DECLARE @ActiveConnections INT\n        SET @ActiveConnections = (SELECT COUNT(*) FROM dbo.ConnectionTracker WHERE LoginName = @LoginName)\n\n        IF @ActiveConnections >= 2\n        BEGIN\n            PRINT 'Maximum number of connections reached for this login.'\n            ROLLBACK;\n        END\n        ELSE\n        BEGIN\n            INSERT INTO dbo.ConnectionTracker (LoginName, SPID)\n            VALUES (@LoginName, @SPID)\n        END\n    END\nEND;