SELECT ac.table_name AS referencing_table,\n       acc.column_name AS referencing_column\nFROM all_constraints ac\nJOIN all_cons_columns acc ON ac.constraint_name = acc.constraint_name\nWHERE ac.r_constraint_name IN (\n    SELECT constraint_name\n    FROM user_constraints uc\n    JOIN user_cons_columns ucc ON uc.constraint_name = ucc.constraint_name\n    WHERE uc.table_name = 'YOUR_TABLE_NAME'\n      AND ucc.column_name = 'PRIMARY_KEY_COLUMN' -- if you know the primary key column name\n)\nAND ac.constraint_type = 'R';