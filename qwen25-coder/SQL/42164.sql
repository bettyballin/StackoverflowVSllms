SELECT UserID, Service, COUNT(*) AS TimesAccessed\nFROM your_table_name\nGROUP BY UserID, Service;