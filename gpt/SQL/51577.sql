-- Customer Table\nCREATE TABLE Customer (\n    CustomerID INT PRIMARY KEY,\n    Name VARCHAR(100)\n);\n\n-- CreditCard Table\nCREATE TABLE CreditCard (\n    CreditCardID INT PRIMARY KEY,\n    CardNumber VARCHAR(16),\n    CustomerID INT,\n    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)\n);\n\n-- Order Table\nCREATE TABLE [Order] (\n    OrderID INT PRIMARY KEY,\n    CustomerID INT,\n    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)\n);\n\n-- Payment Table\nCREATE TABLE Payment (\n    PaymentID INT PRIMARY KEY,\n    OrderID INT,\n    CreditCardID INT,\n    Amount DECIMAL(10, 2),\n    PaymentDate DATE,\n    FOREIGN KEY (OrderID) REFERENCES [Order](OrderID),\n    FOREIGN KEY (CreditCardID) REFERENCES CreditCard(CreditCardID)\n);