SELECT DENSE_RANK() OVER (ORDER BY EmpGroupID) AS Counter, EmpID, EmpGroupID\nFROM Emp\nORDER BY EmpGroupID, EmpID