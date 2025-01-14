CREATE TABLE users (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    username VARCHAR(255) UNIQUE NOT NULL,\n    email VARCHAR(255) UNIQUE NOT NULL,\n    password CHAR(60) NOT NULL,  -- Password should be stored as a hash (length = 60)\n    role ENUM('admin', 'user') DEFAULT 'user'\n);