SELECT \n  student_name,\n  gpa,\n  DENSE_RANK() OVER (ORDER BY gpa DESC) as rank\nFROM \n  students\nORDER BY \n  gpa DESC;