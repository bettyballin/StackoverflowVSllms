CREATE TABLE MyTable (\n    Id INT IDENTITY(1,1) PRIMARY KEY CLUSTERED,\n    GuidColumn UNIQUEIDENTIFIER NOT NULL CONSTRAINT UX_MyTable_Guid UNIQUE NONCLUSTERED,\n    -- other columns\n);