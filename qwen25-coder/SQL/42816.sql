SELECT count(*) FROM Table1 WHERE Table1Id NOT IN (\n    SELECT Table1Id FROM Table2 WHERE id_user = 1\n)