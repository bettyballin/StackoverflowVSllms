CREATE TABLE users (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    mobile_number VARCHAR(15) UNIQUE NOT NULL,\n    email VARCHAR(255) UNIQUE NOT NULL,\n    name VARCHAR(255) NOT NULL\n);