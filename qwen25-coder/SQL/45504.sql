CREATE TABLE AuditLog (\n    LogID INT IDENTITY(1,1) PRIMARY KEY,\n    TableName NVARCHAR(128),\n    ColumnName NVARCHAR(128),\n    ChangedFrom SQL_VARIANT,\n    ChangedTo SQL_VARIANT,\n    UpdatedBy NVARCHAR(128),\n    UpdatedDate DATETIME DEFAULT GETDATE()\n);\n\nCREATE TRIGGER tr_MyTable_Update ON MyTable\nAFTER UPDATE AS\nBEGIN\n    INSERT INTO AuditLog (TableName, ColumnName, ChangedFrom, ChangedTo, UpdatedBy)\n    SELECT \n        'MyTable',\n        col.name,\n        t1.[Column],\n        t2.[Column],\n        USER_NAME()\n    FROM inserted i \n    INNER JOIN deleted d ON i.PK_Column = d.PK_Column\n    INNER JOIN sys.columns AS col ON $Action = 'UPDATE' AND (t1.[Column] <> t2.[Column] OR (t1.[Column] IS NULL AND t2.[Column] IS NOT NULL) OR (t1.[Column] IS NOT NULL AND t2.[Column] IS NULL))\n    OUTER APPLY (\n        SELECT d.Column AS [Column]\n    ) t1\n    OUTER APPLY (\n        SELECT i.Column AS [Column]\n    ) t2;\nEND;