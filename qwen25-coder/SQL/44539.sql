-- Using char(4) for StatusCode\nCREATE TABLE Orders (\n    OrderID INT PRIMARY KEY,\n    ProductName VARCHAR(100),\n    StatusID CHAR(4), -- e.g., 'NEW', 'PROG', 'COMP'\n    FOREIGN KEY (StatusID) REFERENCES OrderStatuses(StatusID)\n);\n\n-- Lookup table for descriptions\nCREATE TABLE OrderStatuses (\n    StatusID CHAR(4) PRIMARY KEY,\n    Description VARCHAR(255) -- e.g., 'New Order', 'Processing', etc.\n);