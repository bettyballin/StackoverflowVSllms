-- Example to create async operations using SQL Server Agent Jobs\nDECLARE @jobName1 NVARCHAR(256) = 'ReportJobPart1';\nDECLARE @jobName2 NVARCHAR(256) = 'ReportJobPart2';\n\n-- Creating Job 1\nEXEC msdb.dbo.sp_add_job \n    @job_name = @jobName1;\n\n-- Adding Step to Job 1\nEXEC msdb.dbo.sp_add_jobstep\n    @job_name = @jobName1,\n    @step_name = N'Run Report Part 1',\n    @subsystem = N'TSQL',\n    @command = N'EXEC YourDatabase.dbo.FirstReportStepProcedure;';\n\n-- Creating Job 2\nEXEC msdb.dbo.sp_add_job \n    @job_name = @jobName2;\n\n-- Adding Step to Job 2\nEXEC msdb.dbo.sp_add_jobstep\n    @job_name = @jobName2,\n    @step_name = N'Run Report Part 2',\n    @subsystem = N'TSQL',\n    @command = N'EXEC YourDatabase.dbo.SecondReportStepProcedure;';\n\n-- Starting the Jobs\nEXEC msdb.dbo.sp_start_job \n    @job_name = @jobName1;\n\nEXEC msdb.dbo.sp_start_job \n    @job_name = @jobName2;