SELECT \n    s.name,\n    s.age,\n    age_count.count\nFROM \n    tbl_students s\nJOIN \n    (SELECT age, COUNT(*) AS count\n     FROM tbl_students\n     GROUP BY age) age_count\nON \n    s.age = age_count.age\nWHERE \n    s.city = 'ny';