SELECT \n    M.PersonName, \n    C.CourseName, \n    D.StartDate, \n    D.EndDate\nFROM \n    Master M\nJOIN \n    Detail D ON M.ID = D.MasterID\nJOIN \n    Course C ON D.CourseID = C.ID\nWHERE \n    (D.MasterID, D.StartDate) IN (\n        SELECT \n            MasterID, \n            MAX(StartDate)\n        FROM \n            Detail\n        GROUP BY \n            MasterID\n    );