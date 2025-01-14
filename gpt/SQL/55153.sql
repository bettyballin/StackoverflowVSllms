CREATE TRIGGER trg_UpdateLastModified\nON YourTableName\nAFTER INSERT, UPDATE\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    UPDATE YourTableName\n    SET LastModified = GETDATE()\n    FROM YourTableName AS t\n    INNER JOIN inserted AS i\n    ON t.YourPrimaryKey = i.YourPrimaryKey;\nEND;