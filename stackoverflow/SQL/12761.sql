SELECT TIMESTAMPDIFF(SECOND, MIN(ts), MAX(ts) ) \n       /\n       (COUNT(DISTINCT(ts)) -1) \nFROM t