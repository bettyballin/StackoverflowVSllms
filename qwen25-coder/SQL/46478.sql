-- Example of creating a temporal table\nCREATE TABLE dbo.YourTable\n(\n    id int primary key,\n    name nvarchar(100),\n    ValidFrom datetime2 GENERATED ALWAYS AS ROW START NOT NULL,\n    ValidTo datetime2 GENERATED ALWAYS AS ROW END NOT NULL,\n    PERIOD FOR SYSTEM_TIME (ValidFrom, ValidTo)\n) WITH(SYSTEM_VERSIONING = ON);\nGO