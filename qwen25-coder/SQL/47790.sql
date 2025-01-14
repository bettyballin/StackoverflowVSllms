-- Create a table with a self-referential foreign key\nCREATE TABLE Employees (\n    EmployeeID INTEGER PRIMARY KEY,\n    LastName TEXT NOT NULL,\n    FirstName TEXT NOT NULL,\n    SupervisorID INTEGER,\n    FOREIGN KEY (SupervisorID) REFERENCES Employees(EmployeeID)\n);