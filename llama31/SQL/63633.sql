CREATE TABLE Products (\n  Id INT PRIMARY KEY,\n  Name VARCHAR(50)\n);\n\nCREATE TABLE ProductTranslations (\n  Id INT PRIMARY KEY,\n  ProductId INT,\n  LanguageCode VARCHAR(5),\n  Name VARCHAR(50),\n  FOREIGN KEY (ProductId) REFERENCES Products(Id)\n);