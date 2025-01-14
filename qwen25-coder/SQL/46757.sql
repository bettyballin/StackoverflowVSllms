-- Capture start values\nSELECT SYSTIMESTAMP AS start_time, IDLE_TICKS AS idle_start, BUSY_TICKS AS busy_start\nINTO   v_start_rec\nFROM   V$OSSTAT;\n\n-- Wait for the desired interval (e.g., 1 minute)\nDBMS_LOCK.SLEEP(60);\n\n-- Capture end values\nSELECT SYSTIMESTAMP AS end_time, IDLE_TICKS AS idle_end, BUSY_TICKS AS busy_end\nINTO   v_end_rec\nFROM   V$OSSTAT;\n\n-- Calculate CPU usage\nv_cpu_usage := (v_end_rec.busy_end - v_start_rec.busy_start) /\n               ((v_end_rec.idle_end - v_start_rec.idle_start) + \n                (v_end_rec.busy_end - v_start_rec.busy_start));