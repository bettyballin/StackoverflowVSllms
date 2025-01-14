START TRANSACTION;\n\n-- Insert into groups table and retrieve the last inserted ID for use in the next insert.\nINSERT INTO groups (group_name) VALUES ('GroupName');\nSET @last_inserted_group_id = LAST_INSERT_ID();\n\n-- Use the retrieved group ID to associate it with a new user.\nINSERT INTO users (user_name, group_id) VALUES ('UserName', @last_inserted_group_id);\n\nCOMMIT;