SELECT \n  ((SUM(CASE WHEN date >= DATE_SUB(CURRENT_DATE, INTERVAL 1 WEEK) THEN hits ELSE 0 END) - \n    SUM(CASE WHEN date >= DATE_SUB(CURRENT_DATE, INTERVAL 2 WEEK) AND date < DATE_SUB(CURRENT_DATE, INTERVAL 1 WEEK) THEN hits ELSE 0 END)) / \n    SUM(CASE WHEN date >= DATE_SUB(CURRENT_DATE, INTERVAL 2 WEEK) AND date < DATE_SUB(CURRENT_DATE, INTERVAL 1 WEEK) THEN hits ELSE 0 END)) * 100 AS popularity\nFROM your_table;