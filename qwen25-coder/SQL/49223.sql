SELECT Date\nFROM your_table_name\nGROUP BY Date\nHAVING COUNT(Date) < k;