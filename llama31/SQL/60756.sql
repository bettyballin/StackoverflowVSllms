SELECT \n  t1.userID,\n  MAX(CASE WHEN t2.question = 'Unit' THEN t2.answer END) AS Unit,\n  MAX(CASE WHEN t2.question = 'Demo' THEN t2.answer END) AS Demo\nFROM \n  table1 t1\n  INNER JOIN table2 t2 ON t1.userID = t2.userID\nWHERE \n  t1.date_submitted > '1/1/2009'\n  AND t2.counter = (SELECT MAX(counter) FROM table2 t3 WHERE t3.userID = t2.userID AND t3.question = t2.question)\nGROUP BY \n  t1.userID\nORDER BY \n  t1.userID;