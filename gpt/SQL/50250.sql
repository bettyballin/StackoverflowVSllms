SELECT EmployeeId\nFROM dbo.EmpDept\nWHERE DeptId IN (1, 2)\nGROUP BY EmployeeId\nHAVING COUNT(DISTINCT DeptId) = 2;