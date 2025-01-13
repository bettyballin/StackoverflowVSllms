SELECT DATE_FORMAT(date_field, '%Y-%m') AS month, COUNT(*) AS count\nFROM your_table\nWHERE YEAR(date_field) = YEAR(CURDATE())\nGROUP BY YEAR(date_field), MONTH(date_field)\nORDER BY YEAR(date_field), MONTH(date_field);