CREATE TABLE Dictionary (\n    WordID INT IDENTITY(1,1) PRIMARY KEY,\n    Word NVARCHAR(255) NOT NULL UNIQUE,\n    Definition NVARCHAR(MAX)\n);