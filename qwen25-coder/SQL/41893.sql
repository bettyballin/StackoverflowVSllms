CREATE PROCEDURE GetEmployeeDetails (@DepartmentId INT)\nAS\nBEGIN\n    SELECT * FROM Employees WHERE DepartmentID = @DepartmentId;\nEND