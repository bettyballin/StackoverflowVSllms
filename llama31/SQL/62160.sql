CREATE TABLE FOO (\n  id INT PRIMARY KEY,\n  fruit_list JSON\n);\n\nINSERT INTO FOO (id, fruit_list) VALUES (1, '["apple", "banana", "orange"]');