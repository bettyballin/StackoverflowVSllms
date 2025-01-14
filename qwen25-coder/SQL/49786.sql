-- Create Department table\nCREATE TABLE Department (\n    DepartmentID INT PRIMARY KEY,\n    Name VARCHAR(100) NOT NULL\n);\n\n-- Create Employee table\nCREATE TABLE Employee (\n    EmployeeID INT PRIMARY KEY,\n    Name VARCHAR(100),\n    DepartmentID INT,\n    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)\n        ON DELETE RESTRICT\n);