SELECT TOP 10\n      qs.total_worker_time / 1000 AS TotalCPUTime_ms,\n      qs.execution_count,\n      qs.total_worker_time / qs.execution_count / 1000 AS AvgCPUTime_ms,\n      SUBSTRING(qt.text, qs.statement_start_offset / 2, \n                (CASE \n                    WHEN qs.statement_end_offset = -1 \n                    THEN LEN(CONVERT(NVARCHAR(MAX), qt.text)) * 2 \n                    ELSE qs.statement_end_offset \n                 END - qs.statement_start_offset) / 2) AS QueryText\n  FROM \n      sys.dm_exec_query_stats qs\n  CROSS APPLY \n      sys.dm_exec_sql_text(qs.sql_handle) qt\n  ORDER BY \n      TotalCPUTime_ms DESC;