INSERT INTO Employees (EmployeeID, DepartmentID) VALUES (1, NULL);\nINSERT INTO Departments (DepartmentID, EmployeeID) VALUES (1, 1);\nUPDATE Employees SET DepartmentID = 1 WHERE EmployeeID = 1;