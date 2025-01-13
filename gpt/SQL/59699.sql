-- Create the parent table\nCREATE TABLE Departments (\n    DepartmentID INT NOT NULL,\n    DepartmentName VARCHAR(100) NOT NULL,\n    PRIMARY KEY (DepartmentID)\n);\n\n-- Create the child table with a foreign key\nCREATE TABLE Employees (\n    EmployeeID INT NOT NULL,\n    EmployeeName VARCHAR(100) NOT NULL,\n    DepartmentID INT,\n    PRIMARY KEY (EmployeeID),\n    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)\n);