CREATE TEMPORARY TABLE codes (code VARCHAR(255));\nINSERT INTO codes VALUES ('code1'), ('code2'), ..., ('code1200');\n\nSELECT * FROM employees \nWHERE code IN (SELECT code FROM codes);