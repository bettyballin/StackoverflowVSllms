CREATE TABLE mytable (\n  id VARCHAR(36) NOT NULL,  -- GUID primary key\n  row_id INT AUTO_INCREMENT NOT NULL,\n  PRIMARY KEY (id, row_id)\n);