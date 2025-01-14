-- Create a global temporary table\nCREATE GLOBAL TEMPORARY TABLE temp_ids (id NUMBER) ON COMMIT DELETE ROWS;\n\n-- Insert your IDs into the temporary table\nINSERT INTO temp_ids VALUES (1);\nINSERT INTO temp_ids VALUES (2);\n-- ... continue inserting all required IDs\n\n-- Use the temporary table in your query\nSELECT * FROM table1 WHERE ID IN (SELECT id FROM temp_ids);