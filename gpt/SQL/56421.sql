DELETE FROM student\nWHERE (course, major) IN (\n    SELECT course, major\n    FROM schedule\n);