ALTER TABLE Employees NOCHECK CONSTRAINT ALL;\nINSERT INTO Employees (EmployeeID, DepartmentID) VALUES (1, 1);\nINSERT INTO Departments (DepartmentID, EmployeeID) VALUES (1, 1);\nALTER TABLE Employees CHECK CONSTRAINT ALL;