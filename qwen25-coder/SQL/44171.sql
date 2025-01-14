CREATE TABLE Products (\n    ProductID INT PRIMARY KEY,\n    SKU VARCHAR(50) UNIQUE NOT NULL,\n    ListPrice DECIMAL(10, 2),\n    Cost DECIMAL(10, 2)\n);\n\nCREATE TABLE CustomerTypes (\n    CustomerTypeID INT PRIMARY KEY,\n    CustomerTypeName VARCHAR(50) NOT NULL\n);\n\nCREATE TABLE Prices (\n    PriceID INT PRIMARY KEY,\n    ProductID INT,\n    PriceType VARCHAR(50), -- e.g., 'Retail', 'Government', 'BPA'\n    Price DECIMAL(10, 2),\n    SaleStartDate DATE,\n    SaleEndDate DATE,\n    CustomerTypeID INT,\n    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),\n    FOREIGN KEY (CustomerTypeID) REFERENCES CustomerTypes(CustomerTypeID)\n);