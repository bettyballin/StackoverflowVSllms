CREATE TABLE Users (\n       user_id INT PRIMARY KEY,\n       username VARCHAR(255),\n       is_deleted BOOLEAN DEFAULT FALSE\n   );\n\n   SELECT * FROM Users WHERE is_deleted = FALSE;