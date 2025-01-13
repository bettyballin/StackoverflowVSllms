-- Categories table\nCREATE TABLE Categories (\n    CategoryID INT PRIMARY KEY,\n    CategoryName VARCHAR(50) NOT NULL\n);\n\n-- Attributes table\nCREATE TABLE Attributes (\n    AttributeID INT PRIMARY KEY,\n    CategoryID INT,\n    AttributeName VARCHAR(50) NOT NULL,\n    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)\n);\n\n-- Products table\nCREATE TABLE Products (\n    ProductID INT PRIMARY KEY,\n    CategoryID INT,\n    ProductName VARCHAR(100) NOT NULL,\n    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)\n);\n\n-- ProductAttributes table\nCREATE TABLE ProductAttributes (\n    ProductID INT,\n    AttributeID INT,\n    AttributeValue VARCHAR(255),\n    PRIMARY KEY (ProductID, AttributeID),\n    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),\n    FOREIGN KEY (AttributeID) REFERENCES Attributes(AttributeID)\n);