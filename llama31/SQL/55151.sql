SELECT *\nFROM your_table\nWHERE purchased >= DATE_SUB(DATE_SUB(CURDATE(), INTERVAL WEEKDAY(CURDATE()) + 1 DAY), INTERVAL 7 DAY)