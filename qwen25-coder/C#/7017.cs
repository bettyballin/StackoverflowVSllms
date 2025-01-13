var employees = db.Employees\n    .Select(e => new EmployeeDTO \n    { \n        EmployeeID = e.EmployeeID, \n        FirstName = e.FirstName,\n        LastName = e.LastName \n    })\n    .ToList();