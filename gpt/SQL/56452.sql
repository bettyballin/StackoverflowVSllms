CREATE TABLE Tenants (\n    TenantID INT PRIMARY KEY,\n    TenantName NVARCHAR(100),\n    IsActive BIT\n);\n\nCREATE TABLE Customers (\n    CustomerID INT PRIMARY KEY,\n    TenantID INT,\n    CustomerName NVARCHAR(100),\n    CONSTRAINT FK_Customers_Tenants FOREIGN KEY (TenantID)\n        REFERENCES Tenants(TenantID)\n);\n\n-- Ensure that any query filters by TenantID to enforce data isolation\nSELECT * FROM Customers WHERE TenantID = @TenantID;