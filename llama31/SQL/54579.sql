CREATE TABLE MyTable (\n    Id INT IDENTITY(100,1) PRIMARY KEY\n);\n\nALTER TABLE MyTable\nADD CONSTRAINT CK_MyTable_Id CHECK (Id BETWEEN 100 AND 999);