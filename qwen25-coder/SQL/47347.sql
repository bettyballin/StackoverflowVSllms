SELECT \n    s.studid,\n    s.name,\n    MAX(CASE WHEN md.subjectid = 3 THEN md.marks END) AS subjectid_3,\n    MAX(CASE WHEN md.subjectid = 4 THEN md.marks END) AS subjectid_4,\n    MAX(CASE WHEN md.subjectid = 5 THEN md.marks END) AS subjectid_5\nFROM \n    student_info s\nLEFT JOIN \n    markdetails md ON s.studid = md.studid\nGROUP BY \n    s.studid, s.name;