-- Step 1: Create Audit Table\nCREATE TABLE dbo.TableAuditLog (\n    TableName NVARCHAR(255),\n    LastUpdated DATETIME DEFAULT GETDATE()\n);\n\n-- Step 2: Insert Trigger\nCREATE TRIGGER trg_MyTable_Insert \nON dbo.MyTargetTable\nINSTEAD OF INSERT\nAS\nBEGIN\n    SET NOCOUNT ON;\n    INSERT INTO dbo.MyTargetTable (Column1, Column2)\n    SELECT Column1, Column2 FROM inserted;\n\n    UPDATE dbo.TableAuditLog\n    SET LastUpdated = GETDATE()\n    WHERE TableName = 'MyTargetTable';\n\n    IF @@ROWCOUNT = 0\n        BEGIN\n            INSERT INTO dbo.TableAuditLog(TableName, LastUpdated)\n            VALUES ('MyTargetTable', GETDATE());\n        END;\nEND\n\n-- Step 3: Update Trigger\nCREATE TRIGGER trg_MyTable_Update \nON dbo.MyTargetTable\nINSTEAD OF UPDATE\nAS\nBEGIN\n    SET NOCOUNT ON;\n    UPDATE t\n    SET Column1 = i.Column1, Column2 = i.Column2\n    FROM dbo.MyTargetTable t\n    INNER JOIN inserted i ON t.PKColumn = i.PKColumn;\n\n    UPDATE dbo.TableAuditLog\n    SET LastUpdated = GETDATE()\n    WHERE TableName = 'MyTargetTable';\n\n    IF @@ROWCOUNT = 0\n        BEGIN\n            INSERT INTO dbo.TableAuditLog(TableName, LastUpdated)\n            VALUES ('MyTargetTable', GETDATE());\n        END;\nEND