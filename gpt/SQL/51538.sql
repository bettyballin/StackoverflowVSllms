SELECT \n    si.studid,\n    si.name,\n    MAX(CASE WHEN md.subjectid = 3 THEN md.marks END) AS subjectid_3,\n    MAX(CASE WHEN md.subjectid = 4 THEN md.marks END) AS subjectid_4,\n    MAX(CASE WHEN md.subjectid = 5 THEN md.marks END) AS subjectid_5\nFROM \n    student_info si\nLEFT JOIN \n    markdetails md ON si.studid = md.studid\nGROUP BY \n    si.studid, si.name;