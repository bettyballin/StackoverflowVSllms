SELECT column_name \nFROM information_schema.columns \nWHERE table_name = 'your_table_name' AND table_schema = 'your_database_name' \nAND (column_comment IS NULL OR column_comment NOT LIKE '%DEPRECATED%');