CREATE TABLE Employees (\n    EmployeeGUID UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID() PRIMARY KEY,\n    FirstName NVARCHAR(50),\n    LastName NVARCHAR(50)\n);