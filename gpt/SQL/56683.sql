INSERT INTO example_table (id, other_column)\n   VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Some Value');