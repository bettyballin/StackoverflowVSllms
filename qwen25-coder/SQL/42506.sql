CREATE TABLE Employees (\n    EmployeeID SERIAL PRIMARY KEY,\n    FirstName VARCHAR(50) NOT NULL,\n    LastName VARCHAR(50) NOT NULL,\n    Email Email NOT NULL UNIQUE, -- Using the domain created above\n    DepartmentID INT,\n    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)\n);