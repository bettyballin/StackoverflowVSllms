-- Example query to get all students including their person attributes\nSELECT p.name, s.student_number\nFROM Person p\nJOIN Student s ON p.person_id = s.student_id;