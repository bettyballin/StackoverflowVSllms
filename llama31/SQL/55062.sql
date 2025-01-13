ALTER TRIGGER [UpdateStageTable] \n   ON  [dbo].[Z_MobileSyncFilters]\n   AFTER INSERT,UPDATE\nAS \nBEGIN\n    SET NOCOUNT ON;\n\n    DECLARE @Table TABLE (AllWos VARCHAR(5000));\n\n    INSERT INTO @Table (AllWos)\n    SELECT AllWos FROM INSERTED;\n\n    DECLARE @AllWos VARCHAR(5000);\n\n    DECLARE cur CURSOR FOR SELECT AllWos FROM @Table;\n\n    OPEN cur;\n\n    FETCH NEXT FROM cur INTO @AllWos;\n\n    WHILE @@FETCH_STATUS = 0\n    BEGIN\n        EXEC Z_UpdateStageTable @AllWos;\n\n        FETCH NEXT FROM cur INTO @AllWos;\n    END\n\n    CLOSE cur;\n    DEALLOCATE cur;\nEND