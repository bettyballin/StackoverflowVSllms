SELECT * \nFROM msdb.dbo.sysjobs j\nINNER JOIN msdb.dbo.sysjobactivity ja ON j.job_id = ja.job_id\nWHERE ja.start_time > GETDATE() AND ja.run_status = 0