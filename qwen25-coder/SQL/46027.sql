CREATE TABLE group_types (\n    type_id INT AUTO_INCREMENT PRIMARY KEY,\n    type_name VARCHAR(50) NOT NULL UNIQUE\n);\n\nCREATE TABLE groups (\n    group_id INT AUTO_INCREMENT PRIMARY KEY,\n    name VARCHAR(255) NOT NULL,\n    type_id INT NOT NULL,\n    FOREIGN KEY (type_id) REFERENCES group_types(type_id)\n);\n\nCREATE TABLE buyer_subtypes (\n    subtype_id INT AUTO_INCREMENT PRIMARY KEY,\n    subtype_name VARCHAR(50) NOT NULL UNIQUE\n);\n\nCREATE TABLE group_buyer_details (\n    group_id INT PRIMARY KEY,\n    subtype_id INT NOT NULL,\n    FOREIGN KEY (group_id) REFERENCES groups(group_id),\n    FOREIGN KEY (subtype_id) REFERENCES buyer_subtypes(subtype_id)\n);