CREATE TABLE website_texts (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    language_code CHAR(2) NOT NULL,\n    key_name VARCHAR(100) NOT NULL,\n    text_content MEDIUMTEXT NOT NULL,\n    UNIQUE (language_code, key_name)\n);