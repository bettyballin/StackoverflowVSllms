-- Create Database\nCREATE DATABASE MyDatabase\nON PRIMARY (\n    NAME = MyDatabase_data,\n    FILENAME = 'C:\Databases\MyDatabase_data.mdf',\n    SIZE = 10MB,\n    MAXSIZE = 100MB,\n    FILEGROWTH = 5MB\n)\nLOG ON (\n    NAME = MyDatabase_log,\n    FILENAME = 'C:\Databases\MyDatabase_log.ldf',\n    SIZE = 5MB,\n    MAXSIZE = 25MB,\n    FILEGROWTH = 5MB\n);\n\n-- Create Table\nCREATE TABLE MyTable (\n    ID INT PRIMARY KEY IDENTITY(1,1),\n    Name NVARCHAR(50),\n    CreatedDate DATETIME DEFAULT GETDATE()\n);\n\n-- Insert Initial Data\nINSERT INTO MyTable (Name) VALUES ('Initial Data');