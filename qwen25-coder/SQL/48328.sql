-- Check current redo log group status and sizes\nSELECT GROUP#, STATUS, BYTES/1024/1024 AS SIZE_MB FROM V$LOG;\n\n-- Check checkpoint information\nSELECT CHECKPOINT_CHANGE# FROM V$DATABASE;\n\n-- Check disk I/O statistics\nSELECT * FROM V$SYSMETRIC WHERE METRIC_NAME = 'Average Synchronous Single-Block Read Latency';\n\n-- Check redo log buffer size\nSHOW PARAMETER LOG_BUFFER;