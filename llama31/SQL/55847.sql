USE msdb\nGO\n\nEXEC sp_add_schedule \n    @schedule_name=N'AutoStartSchedule',\n    @enabled=1,\n    @freq_type=64,  -- Start automatically when SQL Server Agent starts\n    @freq_interval=0,\n    @freq_recurrence_factor=0,\n    @active_start_date=20080101,\n    @active_end_date=99991231,\n    @active_start_time=0,\n    @active_end_time=235959\nGO