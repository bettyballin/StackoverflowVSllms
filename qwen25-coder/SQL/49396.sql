SELECT * FROM your_table\nWHERE purchased >= DATE_SUB(CURDATE(), INTERVAL (WEEKDAY(CURDATE()) + 2) % 7 + 7 DAY)\nAND purchased < DATE_SUB(CURDATE(), INTERVAL (WEEKDAY(CURDATE()) + 2) % 7 DAY);