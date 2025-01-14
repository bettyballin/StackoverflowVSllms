CREATE TABLE summary_table (\n       id INT AUTO_INCREMENT PRIMARY KEY,\n       table1_id INT,\n       table2_id INT,\n       computed_value DECIMAL(10, 2),\n       last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP\n   );