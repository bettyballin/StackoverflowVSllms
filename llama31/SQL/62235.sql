SELECT COUNT(DISTINCT usename) \nFROM pg_stat_activity \nWHERE state = 'active';