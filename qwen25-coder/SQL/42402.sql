CREATE TABLE url_redirects (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    old_url VARCHAR(255) NOT NULL UNIQUE,\n    new_url VARCHAR(255) NOT NULL\n);