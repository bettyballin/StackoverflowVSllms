INSERT INTO table2 (column_name)\nVALUES ((SELECT x FROM table1 WHERE x > 5 LIMIT 1),\n        (SELECT x FROM table1 WHERE x > 5 LIMIT 1 OFFSET 1),\n        (SELECT x FROM table1 WHERE x > 5 LIMIT 1 OFFSET 2),\n        (SELECT x FROM table1 WHERE x > 5 LIMIT 1 OFFSET 3));