CREATE TABLE Departments (\n    DepartmentID INT PRIMARY KEY,\n    DepartmentName NVARCHAR(100)\n);\n\nCREATE TABLE Employees (\n    EmployeeID INT PRIMARY KEY,\n    EmployeeName NVARCHAR(100),\n    DepartmentID INT,\n    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID) ON UPDATE CASCADE\n);