CREATE TABLE primary_table (\n    col1 INT,\n    col2 INT,\n    col3 INT,\n    PRIMARY KEY (col1, col2, col3)\n);\n\nCREATE TABLE foreign_table (\n    ref_col1 INT,\n    ref_col2 INT,\n    ref_col3 INT,\n    -- Other columns\n    FOREIGN KEY (ref_col1, ref_col2, ref_col3) REFERENCES primary_table (col1, col2, col3)\n);