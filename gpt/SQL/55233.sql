INSERT INTO table1 (col1, col2) VALUES ('1', '2');\nGO\n\nIF EXISTS (SELECT * FROM table1 WHERE col1 = '1')\nBEGIN\n    THROW 50000, 'Condition met, terminating script.', 1;\nEND\nGO\n\n-- This part will not execute if the above THROW statement is executed\nINSERT INTO table1 (col1, col2) VALUES ('1', '2');