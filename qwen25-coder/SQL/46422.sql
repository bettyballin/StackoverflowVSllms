-- Create Audit Table\nCREATE TABLE dbo.AuditTable (\n    AuditID INT IDENTITY(1,1) PRIMARY KEY,\n    TableName NVARCHAR(255),\n    ColumnName NVARCHAR(255),\n    PrimaryKeyValue SQL_VARIANT,\n    OldValue SQL_VARIANT,\n    NewValue SQL_VARIANT,\n    ChangedBy NVARCHAR(255),\n    ChangeDate DATETIME DEFAULT GETDATE(),\n    OperationType CHAR(1) -- 'I' for insert, 'U' for update, 'D' for delete\n);\n\n-- Sample Main Table\nCREATE TABLE dbo.MainTable (\n    ID INT PRIMARY KEY,\n    SensitiveData NVARCHAR(MAX)\n);\n\n-- Trigger to log changes\nCREATE TRIGGER trg_MainTable_Audit ON dbo.MainTable \nAFTER INSERT, UPDATE, DELETE\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Handle DELETES\n    IF EXISTS(SELECT 1 FROM deleted) AND NOT EXISTS(SELECT 1 FROM inserted)\n        INSERT INTO dbo.AuditTable (TableName, ColumnName, PrimaryKeyValue, OldValue, ChangedBy, OperationType)\n        SELECT 'dbo.MainTable', dsc.name, i.ID, F.iOldV, USER_NAME(), 'D'\n        FROM deleted i\n        CROSS APPLY (\n            SELECT *\n            FROM [sys].[columns] sc \n                INNER JOIN (SELECT ID) f \n                ON f.[ID] = i.[ID]\n                OUTER APPLY (\n                    SELECT SUBSTRING((\n                        SELECT ',' + dsc.name + '=' + COALESCE(CAST(d.* AS NVARCHAR(MAX)), 'NULL')\n                        FROM deleted d\n                            CROSS APPLY sys.columns dsc\n                        WHERE d.ID = i.ID AND SCHEMA_NAME(o.schema_id)  = 'dbo' \n                            AND o.[name] = 'MainTable'\n                            AND dsc.column_id > 1  -- Skip identity column if exists\n                        ORDER BY dsc.COLUMN_ID\n                        FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 2, 8000) AS iOldV\n                ) f\n        ) dsc;\n    \n    -- Handle INSERTS\n    IF EXISTS(SELECT 1 FROM inserted) AND NOT EXISTS(SELECT 1 FROM deleted)\n        INSERT INTO dbo.AuditTable (TableName, ColumnName, PrimaryKeyValue, NewValue, ChangedBy, OperationType)\n        SELECT 'dbo.MainTable', dsc.name, i.ID, COALESCE(CAST(i.* AS NVARCHAR(MAX)), 'NULL'), USER_NAME(), 'I'\n        FROM inserted i\n        CROSS APPLY (\n            SELECT *\n            FROM [sys].[columns] sc \n                INNER JOIN (SELECT ID) f \n                ON f.[ID] = i.[ID]\n                OUTER APPLY (\n                    SELECT SUBSTRING((\n                        SELECT ',' + dsc.name + '=' + COALESCE(CAST(i.* AS NVARCHAR(MAX)), 'NULL')\n                        FROM inserted i\n                            CROSS APPLY sys.columns dsc\n                        WHERE i.ID = i.ID AND SCHEMA_NAME(o.schema_id)  = 'dbo' \n                            AND o.[name] = 'MainTable'\n                            AND dsc.column_id > 1  -- Skip identity column if exists\n                        ORDER BY dsc.COLUMN_ID\n                        FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 2, 8000) AS iNewV\n                ) f\n        ) dsc;\n\n    -- Handle UPDATES\n    IF EXISTS(SELECT 1 FROM inserted) AND EXISTS (SELECT 1 FROM deleted)\n        INSERT INTO dbo.AuditTable (TableName, ColumnName, PrimaryKeyValue, OldValue, NewValue, ChangedBy, OperationType)\n        SELECT 'dbo.MainTable',\n               col.name,\n               i.ID,\n               COALESCE(CAST(d.[value] AS NVARCHAR(MAX)), 'NULL'),\n               COALESCE(CAST(i.[value] AS NVARCHAR(MAX)), 'NULL'),\n               USER_NAME(),\n               CASE WHEN d.[value] <> i.[value] THEN 'U' END\n        FROM inserted i\n            INNER JOIN deleted d ON i.ID = d.ID\n                CROSS APPLY sys.columns col\n                    OUTER APPLY (SELECT [value] = CONVERT(VARBINARY(MAX), d.[col])) dc(col)\n                    OUTER APPLY (SELECT [value] = CONVERT(VARBINARY(MAX), i.[col])) ic(col)\n        WHERE CASE WHEN d.[value] <> i.[value] THEN 1 ELSE 0 END = 1\n            AND SCHEMA_NAME(o.schema_id)  = 'dbo'\n            AND o.[name] = 'MainTable';\nEND;