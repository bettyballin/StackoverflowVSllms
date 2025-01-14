-- Creating a UNIQUE constraint\nCREATE TABLE MyTable (\n    ID INT NOT NULL,\n    Name VARCHAR(100),\n    CONSTRAINT UQ_MyTable_Name UNIQUE (Name)\n);\n\n-- Creating a UNIQUE index\nCREATE UNIQUE INDEX IX_MyTable_Name ON MyTable(Name);