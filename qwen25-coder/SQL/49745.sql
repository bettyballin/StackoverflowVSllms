-- Table with specific nvarchar size\nCREATE TABLE SpecificSize (\n    ID INT PRIMARY KEY,\n    Description NVARCHAR(255)\n);\n\n-- Table with nvarchar MAX\nCREATE TABLE MaxSize (\n    ID INT PRIMARY KEY,\n    Description NVARCHAR(MAX)\n);