CREATE TABLE example (\n    id INT PRIMARY KEY,\n    name VARCHAR(50),\n    value INT\n);\n\nINSERT INTO example (id, name, value) VALUES\n(1, 'Alice', 100),\n(2, 'Bob', NULL),\n(3, NULL, 200);