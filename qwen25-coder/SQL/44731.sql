-- Create a new database in MSSQL\nCREATE DATABASE SampleDB\nON PRIMARY (\n    NAME = 'SampleDB_Data',\n    FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\Data\SampleDB.mdf',\n    SIZE = 50MB,\n    MAXSIZE = UNLIMITED,\n    FILEGROWTH = 5MB\n)\nLOG ON (\n    NAME = 'SampleDB_Log',\n    FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\Data\SampleDB_log.ldf',\n    SIZE = 20MB,\n    MAXSIZE = UNLIMITED,\n    FILEGROWTH = 5MB\n);