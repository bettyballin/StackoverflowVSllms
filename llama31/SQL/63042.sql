CREATE TABLE code_examples (\n  id INT PRIMARY KEY,\n  code TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci\n);\n\nINSERT INTO code_examples (code) VALUES ('SELECT * FROM users WHERE id = 1;');\n\nSELECT * FROM code_examples;