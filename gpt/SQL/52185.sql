CREATE TABLE Files (\n       FileId INT PRIMARY KEY IDENTITY,\n       FileName NVARCHAR(255),\n       ContentType NVARCHAR(100),\n       FileData VARBINARY(MAX)\n   );