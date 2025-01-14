USE [msdb]\nGO\n\n/****** Object:  Job [TestJob]    Script Date: YYYY/MM/DD HH:MM:SS ******/\nIF EXISTS (SELECT name FROM msdb.dbo.sysjobs_view WHERE name = N'TestJob')\nEXEC msdb.dbo.sp_delete_job @job_name=N'TestJob', @delete_unused_schedule=1\nGO\n\nUSE [msdb]\nGO\n\nBEGIN TRANSACTION\nDECLARE @ReturnCode INT\nSELECT @ReturnCode = 0\n\n/****** Object:  JobCategory [[Uncategorized (Local)]]]    Script Date: YYYY/MM/DD HH:MM:SS ******/\nIF NOT EXISTS (SELECT name FROM msdb.dbo.syscategories WHERE name=N'[Uncategorized (Local)]' AND category_class=1)\nBEGIN\nEXEC @ReturnCode = msdb.dbo.sp_add_category @class=N'JOB', @type=N'LOCAL', @name=N'[Uncategorized (Local)]'\nIF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback\n\nEND\n\nDECLARE @jobId BINARY(16)\nEXEC @ReturnCode =  msdb.dbo.sp_add_job @job_name=N'TestJob', \n        @enabled=1, \n        @notify_level_eventlog=3, \n        @notify_level_email=0, \n        @notify_level_netsend=0, \n        @notify_level_page=0, \n        @delete_level=0, \n        @description=N'No description available.', \n        @category_name=N'[Uncategorized (Local)]', \n        @owner_login_name=N'Administrator', @job_id = @jobId OUTPUT\nIF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback\n\n/****** Object:  Step [print]    Script Date: YYYY/MM/DD HH:MM:SS ******/\nEXEC @ReturnCode = msdb.dbo.sp_add_jobstep @job_id=@jobId, @step_name=N'print', \n        @step_id=1, \n        @cmdexec_success_code=0, \n        @on_success_action=1, \n        @on_success_step_id=0, \n        @on_fail_action=2, \n        @on_fail_step_id=0, \n        @retry_attempts=0, \n        @retry_interval=0, \n        @freq_subday_type=1, \n        @freq_subday_interval=0, \n        @freq_relative_interval=0, \n        @freq_recurrence_factor=1, \n        @active_start_date=20090803, \n        @active_end_date=99991231, \n        @active_start_time=0, \n        @active_end_time=235959\nIF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback\n\nEXEC @ReturnCode = msdb.dbo.sp_update_job @job_id = @jobId, @start_step_id = 1\nIF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback\n\nEXEC @ReturnCode = msdb.dbo.sp_add_jobschedule @job_id=@jobId, @name=N'testschdeule', \n        @enabled=1, \n        @freq_type=8, \n        @freq_interval=1, \n        @freq_subday_type=1, \n        @freq_subday_interval=0, \n        @freq_relative_interval=0, \n        @freq_recurrence_factor=1, \n        @active_start_date=20090803, \n        @active_end_date=99991231, \n        @active_start_time=0, \n        @active_end_time=235959\nIF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback\n\nEXEC @ReturnCode = msdb.dbo.sp_add_jobserver @job_id = @jobId, @server_name = N'(local)'\nIF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback\n\nCOMMIT TRANSACTION\nGOTO EndSave\n\nQuitWithRollback:\n    IF (@@TRANCOUNT > 0) ROLLBACK TRANSACTION\n\nEndSave:\n\nGO