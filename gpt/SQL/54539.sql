SELECT\n       table_name,\n       column_name,\n       constraint_name,\n       referenced_table_name,\n       referenced_column_name\n   FROM\n       information_schema.key_column_usage\n   WHERE\n       referenced_table_name = 'addresses';