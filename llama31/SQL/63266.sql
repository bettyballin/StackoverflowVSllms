CREATE TABLE unique_values (\n    column_name data_type PRIMARY KEY\n);\n\nCREATE TABLE child_table1 (\n    id SERIAL PRIMARY KEY,\n    column_name data_type NOT NULL,\n    FOREIGN KEY (column_name) REFERENCES unique_values(column_name)\n);\n\nCREATE TABLE child_table2 (\n    id SERIAL PRIMARY KEY,\n    column_name data_type NOT NULL,\n    FOREIGN KEY (column_name) REFERENCES unique_values(column_name)\n);