CREATE TABLE mytable (\n    id INT IDENTITY(1,1) PRIMARY KEY,\n    guid UNIQUEIDENTIFIER DEFAULT (NEWID())\n);