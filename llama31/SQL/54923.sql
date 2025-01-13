SELECT \n  COUNT(CASE WHEN MONTH(date_field) = 1 THEN 1 END) AS january,\n  COUNT(CASE WHEN MONTH(date_field) = 2 THEN 1 END) AS february,\n  ...\n  COUNT(CASE WHEN MONTH(date_field) = 12 THEN 1 END) AS december\nFROM your_table;