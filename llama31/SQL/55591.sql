SELECT CASE WHEN (my boolean expression) THEN 'my message' ELSE (SELECT TOP 1 name FROM people) END AS result