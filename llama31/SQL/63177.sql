BEGIN TRANSACTION;\nINSERT INTO your_table_name (...) VALUES (...);\n-- Insert 10,000 rows\nCOMMIT TRANSACTION;\n\nBEGIN TRANSACTION;\nINSERT INTO your_table_name (...) VALUES (...);\n-- Insert next 10,000 rows\nCOMMIT TRANSACTION;