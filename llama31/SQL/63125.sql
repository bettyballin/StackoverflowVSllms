CREATE TEMPORARY TABLE user_ids (user_id INT PRIMARY KEY);\nINSERT INTO user_ids VALUES (32343), (45676), (12345), ...;\n\nSELECT * FROM customers\nJOIN user_ids ON customers.user_id = user_ids.user_id;