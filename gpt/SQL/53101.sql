SELECT user_id, meta_value AS port \nFROM your_table_name \nWHERE meta_key = 'port' AND user_id IN (1, 2);