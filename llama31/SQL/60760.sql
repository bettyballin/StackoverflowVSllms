ALTER TABLE new_table_1\nADD CONSTRAINT fk_new_table_1_new_table_2\nFOREIGN KEY (column_2) REFERENCES new_table_2(id);