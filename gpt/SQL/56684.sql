SELECT sql_text\nFROM v$sqlarea\nWHERE sql_text LIKE '%your_table_name%'\nORDER BY last_active_time DESC;