SELECT subselectresult\nFROM (\n  SELECT (SELECT 1 FROM table WHERE somereallycomplicatedclause = 'something') AS subselectresult\n) AS derived_table\nWHERE subselectresult = 1