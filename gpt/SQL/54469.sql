USE PseudoTempDB;\nGO\n\nCREATE TABLE PersistentTempTable (\n    -- Define your columns here\n    ID INT PRIMARY KEY,\n    Data NVARCHAR(100),\n    CreatedAt DATETIME DEFAULT GETDATE()\n);