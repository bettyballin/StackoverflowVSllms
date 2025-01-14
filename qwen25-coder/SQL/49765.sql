-- Creating Customers table\nCREATE TABLE Customers (\n    CustomerID INT PRIMARY KEY,\n    Name VARCHAR(255),\n    Email VARCHAR(255)\n);\n\n-- Creating Orders table\nCREATE TABLE Orders (\n    OrderID INT PRIMARY KEY,\n    CustomerID INT,\n    Amount DECIMAL(10, 2),\n    ORDER DATE,\n    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)\n);\n\n-- Query to get all orders with customer details\nSELECT Orders.OrderID, Customers.Name, Orders.Amount, Orders.OrderDate \nFROM Orders\nJOIN Customers ON Orders.CustomerID = Customers.CustomerID;