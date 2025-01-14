-- Enable result cache at system level\nALTER SYSTEM SET result_cache_max_size = 100M;\n\n-- Enable result cache at session level\nALTER SESSION SET result_cache_mode = FORCE;\n\n-- Example of a SQL query using result cache\nSELECT /*+ RESULT_CACHE */ employee_id, first_name, last_name\nFROM employees\nWHERE department_id = 10;