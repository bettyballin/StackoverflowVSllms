SELECT TOP 10\n       text,\n       start_time,\n       status,\n       cpu_time,\n       total_elapsed_time,\n       logical_reads,\n       reads,\n       writes,\n       session_id\n   FROM sys.dm_exec_requests\n   ORDER BY cpu_time DESC;