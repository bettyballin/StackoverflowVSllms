EXEC DBMS_STATS.GATHER_SYSTEM_STATS('start');\n   -- Run a representative workload here\n   EXEC DBMS_STATS.GATHER_SYSTEM_STATS('stop');