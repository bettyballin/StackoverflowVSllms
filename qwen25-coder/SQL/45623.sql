CREATE TABLE Customers (\n    CustomerID int NOT NULL PRIMARY KEY,\n    CustomerName varchar(255)\n);\n\nCREATE TABLE Orders (\n    OrderID int NOT NULL AUTO_INCREMENT PRIMARY KEY,\n    CustomerID int NOT NULL FOREIGN KEY REFERENCES Customers(CustomerID)\n);\n\nCREATE TABLE Products (\n    ProductID int NOT NULL PRIMARY KEY,\n    ProductName varchar(255),\n    ProductPrice decimal(10, 2)\n);\n\nCREATE TABLE OrderDetails (\n    OrderDetailID int NOT NULL AUTO_INCREMENT PRIMARY KEY,\n    OrderID int NOT NULL FOREIGN KEY REFERENCES Orders(OrderID),\n    ProductID int NOT NULL FOREIGN KEY REFERENCES Products(ProductID),\n    Quantity int\n);