CREATE TABLE example (\n  id INT,\n  name VARCHAR(50)\n);\n\nINSERT INTO example (id, name) VALUES\n  (1, 'Alice'),\n  (2, NULL),\n  (3, 'Bob'),\n  (4, NULL),\n  (5, 'Charlie');\n\nSELECT COUNT(*), COUNT(name) FROM example;