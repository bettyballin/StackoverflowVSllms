CREATE TABLE your_table (\n    a_column VARCHAR(255),\n    b_column VARCHAR(255),\n    UNIQUE KEY unique_a_b (a_column, b_column)\n);