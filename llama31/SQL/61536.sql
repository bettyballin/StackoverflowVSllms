CREATE TABLE access_control_rules (\n  id INT PRIMARY KEY,\n  role_id INT,\n  table_name VARCHAR(255),\n  column_name VARCHAR(255),\n  filter_condition VARCHAR(255)\n);