UPDATE YourTableName AS t\n    INNER JOIN EmployeeMapping AS m \n    ON t.YourFieldName = m.EmployeeName\n    SET t.YourFieldName = m.EmployeeID