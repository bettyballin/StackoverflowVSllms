SELECT 1 \n  FROM (SELECT 1) t \n WHERE EXISTS( SELECT * FROM foo WHERE id = 42 )