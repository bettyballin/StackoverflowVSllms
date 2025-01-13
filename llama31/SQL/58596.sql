SELECT \n  s1.name, \n  s1.age, \n  COUNT(s2.age) AS age_count\nFROM \n  tbl_students s1 USE INDEX (age)\n  LEFT JOIN tbl_students s2 ON s1.age = s2.age\nWHERE \n  s1.city = 'ny'\nGROUP BY \n  s1.name, s1.age