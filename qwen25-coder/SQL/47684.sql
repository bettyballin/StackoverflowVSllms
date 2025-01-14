-- Separate tables for each certificate\nCREATE TABLE Certificate1 (\n    id INT PRIMARY KEY,\n    certificate_data TEXT NOT NULL\n);\n\nCREATE TABLE Certificate2 (\n    id INT PRIMARY KEY,\n    certificate_data TEXT NOT NULL\n);\n\nCREATE TABLE Certificate3 (\n    id INT PRIMARY KEY,\n    certificate_data TEXT NOT NULL\n);\n\n-- Single table with a type identifier for each certificate\nCREATE TABLE Certificates (\n    id INT PRIMARY KEY AUTO_INCREMENT,\n    certificate_type VARCHAR(50) NOT NULL UNIQUE,\n    certificate_data TEXT NOT NULL\n);