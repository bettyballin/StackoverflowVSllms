CREATE TABLE users (\n       user_id INT PRIMARY KEY,\n       username VARCHAR(255) NOT NULL,\n       flags JSONB\n   );