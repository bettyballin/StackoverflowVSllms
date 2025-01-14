CREATE TABLE MultipleIdentities (\n    ID1 INT IDENTITY(1,1) PRIMARY KEY,\n    ID2 INT IDENTITY(1,1)\n);\n\n-- Inserting data would lead to issues since both columns attempt to auto-increment independently.\nINSERT INTO MultipleIdentities DEFAULT VALUES;