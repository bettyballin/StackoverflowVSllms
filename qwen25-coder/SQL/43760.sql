ALTER TRIGGER [UpdateStageTable] \n   ON  [dbo].[Z_MobileSyncFilters]\n   AFTER INSERT, UPDATE\nAS \nBEGIN\n    SET NOCOUNT ON;\n\n    DECLARE @TempWos TABLE (AllWos VARCHAR(5000));\n\n    INSERT INTO @TempWos (AllWos)\n    SELECT AllWos FROM INSERTED;\n\n    DECLARE @AllWos AS VARCHAR(5000);\n    WHILE EXISTS(SELECT 1 FROM @TempWos)\n    BEGIN\n        SELECT TOP 1 @AllWos = AllWos FROM @TempWos;\n        EXEC Z_UpdateStageTable @AllWos;\n        DELETE @TempWos WHERE AllWos = @AllWos;\n    END\nEND