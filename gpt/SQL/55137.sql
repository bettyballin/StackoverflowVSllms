CREATE TABLE items (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    name VARCHAR(255) NOT NULL,\n    attribute1 BOOLEAN,\n    attribute2 BOOLEAN,\n    attribute3 BOOLEAN,\n    -- Add columns up to attribute40\n    attribute40 BOOLEAN\n);