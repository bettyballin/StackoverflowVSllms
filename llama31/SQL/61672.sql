CREATE TABLE mytable (\n  id INT PRIMARY KEY,\n  data VARCHAR(255),\n  last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP\n);