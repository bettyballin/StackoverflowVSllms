CREATE TEMP TABLE mapper (old_val CHAR(5) NOT NULL, new_val CHAR(5) NOT NULL);\n...multiple inserts into mapper...\nINSERT INTO mapper(old_val, new_val) VALUES('a.1', 'a1');\nINSERT INTO mapper(old_val, new_val) VALUES('a-1', 'a1');\nINSERT INTO mapper(old_val, new_val) VALUES('b.1', 'b1');\nINSERT INTO mapper(old_val, new_val) VALUES('b-1', 'b1');\n...etcetera...\n\nUPDATE tbl\n   SET title = (SELECT new_val FROM mapper WHERE old_val = tbl.title)\n   WHERE title IN (SELECT old_val FROM mapper);