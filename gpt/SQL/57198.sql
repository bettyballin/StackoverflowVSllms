SELECT SUM(mins_spent) AS time_sum \nFROM todos \nWHERE lastUpdate >= NOW() - INTERVAL 1 WEEK;