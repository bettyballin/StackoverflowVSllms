SELECT BUSY_TICKS / (IDLE_TICKS + BUSY_TICKS) AS avg_cpu_load\nFROM V$OSSTAT;