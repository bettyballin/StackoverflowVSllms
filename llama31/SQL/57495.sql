SELECT \n  s.Student_Name, \n  s.Student_Email, \n  CASE \n    WHEN COUNT(CASE WHEN e.IsActive = 1 THEN 1 END) > 0 \n    THEN 'Yes' \n    ELSE 'No' \n  END AS IsEnrolled\nFROM \n  Student s\n  LEFT JOIN Enrollment e ON s.Student_ID = e.Student_ID\nGROUP BY \n  s.Student_Name, s.Student_Email;