SELECT \n    s.Student_Name,\n    s.Student_Email,\n    CASE \n        WHEN EXISTS (\n            SELECT 1 \n            FROM Enrollment e \n            WHERE e.Student_ID = s.Student_ID \n              AND e.Status = 'Active'\n        ) THEN 'Yes'\n        ELSE 'No'\n    END AS HasActiveEnrollment\nFROM \n    Student s;