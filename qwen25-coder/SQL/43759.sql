ALTER TRIGGER [UpdateStageTable] \n   ON  [dbo].[Z_MobileSyncFilters]\n   AFTER INSERT, UPDATE\nAS \nBEGIN\n    SET NOCOUNT ON;\n\n    DECLARE @AllWos AS VARCHAR(5000);\n    DECLARE inserted_cursor CURSOR FOR SELECT AllWos FROM INSERTED;\n    OPEN inserted_cursor;\n\n    FETCH NEXT FROM inserted_cursor INTO @AllWos;\n    WHILE @@FETCH_STATUS = 0\n    BEGIN\n        EXEC Z_UpdateStageTable @AllWos;\n        FETCH NEXT FROM inserted_cursor INTO @AllWos;\n    END\n\n    CLOSE inserted_cursor;\n    DEALLOCATE inserted_cursor;\nEND