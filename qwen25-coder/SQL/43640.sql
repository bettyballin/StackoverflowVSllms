SELECT \n    s.Student_Name,\n    s.Student_Email,\n    CASE \n        WHEN MAX(e.Status) = 'Active' THEN 'Yes'\n        ELSE 'No'\n    END AS isEnrolled\nFROM \n    Student s\nLEFT JOIN \n    Enrollment e ON s.Student_ID = e.Student_ID\nGROUP BY \n    s.Student_ID, s.Student_Name, s.Student_Email;