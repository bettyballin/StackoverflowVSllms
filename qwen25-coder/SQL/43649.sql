-- Create a new schema if it doesn't exist\nIF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = N'HR')\nEXEC('CREATE SCHEMA [HR]')\n\n-- Create a stored procedure within the HR schema\nCREATE PROCEDURE HR.AddEmployee\n    @FirstName NVARCHAR(50),\n    @LastName NVARCHAR(50),\n    @HireDate DATE\nAS\nBEGIN\n    INSERT INTO Employees (FirstName, LastName, HireDate) VALUES (@FirstName, @LastName, @HireDate)\nEND\nGO\n\n-- Create another schema for different functionalities\nIF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = N'FIN')\nEXEC('CREATE SCHEMA [FIN]')\n\n-- Create a stored procedure within the FIN schema\nCREATE PROCEDURE FIN.ProcessPayroll\n    @PeriodStart DATE,\n    @PeriodEnd DATE\nAS\nBEGIN\n    -- Payroll processing logic here\nEND\nGO