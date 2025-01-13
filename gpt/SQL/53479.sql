SELECT E.RefDepartmentID, SUM(PTran.Hours)\nFROM Employee E\nJOIN ProjectType PType\n    ON E.RefCustomerID = PType.RefCustomerID\nJOIN Project P\n    ON PType.ProjectTypeID = P.RefProjectTypeID\nJOIN ProjectTransaction PTran\n    ON E.EmployeeID = PTran.RefEmployeeID\n    AND P.ProjectID = PTran.RefProjectID\nWHERE E.RefDepartmentID = @departmentID\n    AND @from <= PTran.Date AND PTran.Date <= @to\n    AND PTran.Type = 0\n    AND PType.ProjectTypeName NOT IN (N'1', N'2', N'3')\nGROUP BY E.RefDepartmentID