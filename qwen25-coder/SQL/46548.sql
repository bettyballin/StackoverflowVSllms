-- Example of identifying tables with similar constraints:\nSELECT owner, table_name, constraint_type, search_condition \nFROM all_constraints\nWHERE table_name = 'YOUR_TABLE_NAME'\nAND constraint_type = 'P';\n\n-- Example of creating a composite index (large index):\nCREATE INDEX idx_large ON your_table(owner_id, column1, column2);\n\n-- Example of adding a foreign key:\nALTER TABLE child_table\nADD CONSTRAINT fk_constraint FOREIGN KEY (child_owner_id) \nREFERENCES parent_table(owner_id);