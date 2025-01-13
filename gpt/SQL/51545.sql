SELECT \n  busy_ticks / (idle_ticks + busy_ticks) AS avg_cpu_load\nFROM \n  v$osstat\nWHERE \n  stat_name IN ('IDLE_TICKS', 'BUSY_TICKS');