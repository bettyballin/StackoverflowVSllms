SELECT em.Code,\n    (SELECT et.Name + ' '  AS 'data()'\n        FROM tblEmployeeTag et\n            JOIN tblEmployeeTagAssignment eta ON et.Id = eta.EmployeeTag_Id AND eta.Employee_Id = em.id\n    FOR XML PATH('') ) AS Tags\nFROM tblEmployee em