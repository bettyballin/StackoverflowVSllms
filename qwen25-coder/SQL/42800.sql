SELECT SUM(TIMESTAMPDIFF(HOUR, start_time, end_time)) AS total_duration_hours\nFROM your_table_name;