CREATE TABLE Products (\n    ProductID INT PRIMARY KEY,\n    -- Other product-specific columns\n);\n\nCREATE TABLE Translations (\n    TranslationID INT PRIMARY KEY,\n    TableName NVARCHAR(255),\n    ColumnName NVARCHAR(255),\n    RowID INT,\n    LanguageCode NVARCHAR(10),\n    TranslatedText NVARCHAR(MAX),\n    FOREIGN KEY (RowID) REFERENCES Products(ProductID)\n);