-- Create a table for customers\nCREATE TABLE Customers (\n    CustomerID INT PRIMARY KEY,\n    FirstName VARCHAR(50),\n    LastName VARCHAR(50),\n    Email VARCHAR(100)\n);\n\n-- Create a table for orders\nCREATE TABLE Orders (\n    OrderID INT PRIMARY KEY,\n    OrderDate DATE,\n    CustomerID INT,\n    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)\n);\n\n-- Create a table for products\nCREATE TABLE Products (\n    ProductID INT PRIMARY KEY,\n    ProductName VARCHAR(100),\n    Price DECIMAL(10, 2)\n);\n\n-- Create a table for order items\nCREATE TABLE OrderItems (\n    OrderItemID INT PRIMARY KEY,\n    OrderID INT,\n    ProductID INT,\n    Quantity INT,\n    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),\n    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)\n);