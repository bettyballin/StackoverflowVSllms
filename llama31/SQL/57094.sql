-- Stored Procedure Example\nCREATE PROCEDURE GetEmployeeDetails\n    @EmployeeID INT\nAS\nBEGIN\n    SELECT * FROM Employees WHERE EmployeeID = @EmployeeID\nEND\nGO\n\n-- Inline Statement Example\nSELECT * FROM Employees WHERE EmployeeID = 123