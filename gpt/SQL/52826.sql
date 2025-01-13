SELECT \n    SUM(CASE WHEN T1.A = 1 THEN 1 ELSE 0 END) AS A_COUNT,\n    SUM(CASE WHEN T1.B = 2 THEN 1 ELSE 0 END) AS B_COUNT\nFROM T1;