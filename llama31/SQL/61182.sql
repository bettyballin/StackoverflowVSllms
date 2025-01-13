CREATE TABLE Products (\n    Id INT PRIMARY KEY,\n    -- product-specific columns\n);\n\nCREATE TABLE Categories (\n    Id INT PRIMARY KEY,\n    -- category-specific columns\n);\n\nCREATE TABLE ProductCategories (\n    ProductId INT NOT NULL,\n    CategoryId INT NOT NULL,\n    PRIMARY KEY (ProductId, CategoryId),\n    FOREIGN KEY (ProductId) REFERENCES Products(Id),\n    FOREIGN KEY (CategoryId) REFERENCES Categories(Id)\n);