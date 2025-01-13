CREATE TABLE linked_list (\n  id INT PRIMARY KEY,\n  value VARCHAR(255),\n  next_id INT,\n  FOREIGN KEY (next_id) REFERENCES linked_list(id)\n);