CREATE TABLE Person (\n    PersonId INT PRIMARY KEY,\n    PersonTypeId TINYINT -- Foreign Key to PersonTypes\n);\n\nCREATE TABLE PersonTypes (\n    PersonTypeId TINYINT PRIMARY KEY,\n    PersonTypeName VARCHAR(50)\n);