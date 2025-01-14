CREATE TABLE Orders (\n        OrderID INT PRIMARY KEY,\n        CustomerID INT,\n        FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)\n            ON DELETE SET NULL  -- or CASCADE, RESTRICT, etc.\n    );