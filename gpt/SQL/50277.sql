SELECT * FROM (\n       SELECT * FROM users ORDER BY id\n   ) WHERE ROWNUM <= 100;