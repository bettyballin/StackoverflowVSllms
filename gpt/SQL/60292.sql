-- Holds current Employee Entity\nCREATE TABLE Employees (\n    EmployeeId INT PRIMARY KEY,\n    FirstName VARCHAR(100),\n    LastName VARCHAR(100),\n    DepartmentId INT,\n    CurrentVersionId INT,\n    -- Other fields\n    FOREIGN KEY (CurrentVersionId) REFERENCES EmployeeVersions(VersionId)\n);\n\n-- Holds Employee Revisions\nCREATE TABLE EmployeeVersions (\n    VersionId INT PRIMARY KEY AUTO_INCREMENT,\n    EmployeeId INT,\n    FirstName VARCHAR(100),\n    LastName VARCHAR(100),\n    DepartmentId INT,\n    DateModified DATETIME,\n    -- Other fields\n    FOREIGN KEY (EmployeeId) REFERENCES Employees(EmployeeId)\n);