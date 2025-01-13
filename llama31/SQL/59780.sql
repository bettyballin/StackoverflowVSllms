SELECT \n  SUM(CASE WHEN EXTRACT(MONTH FROM JoinDate) = 1 THEN 1 ELSE 0 END) AS jan,\n  SUM(CASE WHEN EXTRACT(MONTH FROM JoinDate) = 2 THEN 1 ELSE 0 END) AS feb,\n  SUM(CASE WHEN EXTRACT(MONTH FROM JoinDate) = 3 THEN 1 ELSE 0 END) AS mar,\n  SUM(CASE WHEN EXTRACT(MONTH FROM JoinDate) = 4 THEN 1 ELSE 0 END) AS apr\nFROM student;