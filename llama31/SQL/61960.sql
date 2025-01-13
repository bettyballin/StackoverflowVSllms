SELECT emp_id, name, occupation\nFROM (\n  SELECT emp_id, name, occupation,\n         ROW_NUMBER() OVER (PARTITION BY occupation ORDER BY emp_id) AS row_num\n  FROM your_table\n)\nWHERE row_num <= 3;