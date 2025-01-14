SELECT e1.name, \n       e2.name, \n       e1Manager.name\n  FROM Employee e1\nCROSS JOIN Employee e2\nINNER JOIN Employee e1Manager \n    ON e1.managerEmployeeID = e1Manager.employeeID