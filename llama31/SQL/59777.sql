SELECT COUNT(id)\nFROM stats\nGROUP BY YEAR(record_date), MONTH(record_date), DAY(record_date);