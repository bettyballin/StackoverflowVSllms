var result = db.GetEmployees(); // Assuming GetEmployees is your stored procedure\n    var employees = result.Select(r => new Employee\n    {\n        EmployeeID = r.EmployeeID,\n        EmployeeName = r.EmployeeName,\n        // Map other properties as needed\n    }).ToList();