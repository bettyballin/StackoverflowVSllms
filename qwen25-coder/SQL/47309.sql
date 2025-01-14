CREATE FUNCTION dbo.GetEmployeesByDepartmentId\n(\n    @DeptId INT\n)\nRETURNS TABLE\nAS\nRETURN \n(\n    SELECT EmployeeId, Name, Position\n    FROM Employees\n    WHERE DepartmentId = @DeptId\n);