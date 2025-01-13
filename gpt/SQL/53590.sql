CREATE TABLE records (\n    id INT PRIMARY KEY AUTO_INCREMENT,\n    data VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE file_associations (\n    id INT PRIMARY KEY AUTO_INCREMENT,\n    record_id INT,\n    file_path VARCHAR(255) NOT NULL,\n    FOREIGN KEY (record_id) REFERENCES records(id)\n);