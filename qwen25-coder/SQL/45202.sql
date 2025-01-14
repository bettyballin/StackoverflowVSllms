CREATE TABLE articles (\n    id INT PRIMARY KEY AUTO_INCREMENT,\n    title VARCHAR(255),\n    content TEXT,  -- Store HTML here if it's less than ~1MB\n    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);