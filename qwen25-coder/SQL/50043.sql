SELECT \n    CASE \n        WHEN (my boolean expression) THEN 'my message'\n        ELSE (SELECT TOP 1 name FROM people)\n    END AS result;