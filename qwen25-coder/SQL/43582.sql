CREATE TABLE your_table (\n    guid CHAR(36) NOT NULL,\n    increment_id INT AUTO_INCREMENT NOT NULL,\n    -- other columns...\n    PRIMARY KEY (guid, increment_id)\n);