CREATE TABLE users (\n    user_id INT PRIMARY KEY,\n    username VARCHAR(50) NOT NULL,\n    email VARCHAR(255) NOT NULL,\n    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL\n);