SELECT COUNT(*) AS count_today\nFROM your_table\nWHERE DATE(date_field) = CURDATE();