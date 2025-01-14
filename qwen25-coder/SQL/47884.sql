SELECT \n    r.session_id,\n    r.status,\n    r.command,\n    r.percent_complete,\n    CONVERT(VARCHAR(20), DATEADD(SECOND,estimated_completion_time / 1000, GETDATE()), 20) AS estimated_completion_time,\n    (r.total_elapsed_time - r.wait_time) / 1000.0 AS elapsed_time_seconds,\n    CASE r.command\n        WHEN 'BACKUP DATABASE' THEN 'Backup'\n        WHEN 'RESTORE DATABASE' THEN 'Restore'\n        ELSE r.command\n    END AS operation_type,\n    t.text AS script_executed\nFROM \n    sys.dm_exec_requests r\nCROSS APPLY \n    sys.dm_exec_sql_text(r.sql_handle) t\nWHERE \n    (r.status = 'RUNNING' AND r.command IN ('BACKUP DATABASE', 'RESTORE DATABASE'))\nORDER BY \n    percent_complete;