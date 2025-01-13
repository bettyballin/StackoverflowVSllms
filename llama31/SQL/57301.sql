SELECT j.name, ja.start_time, DATEDIFF(mi, ja.start_time, GETDATE()) AS runtime_minutes\nFROM msdb.dbo.sysjobs j\nINNER JOIN msdb.dbo.sysjobactivity ja ON j.job_id = ja.job_id\nWHERE ja.run_status = 1