DECLARE @job_name NVARCHAR(128) = N'YourJobName'; -- Replace with your job name\n\nIF EXISTS (SELECT job_id FROM msdb.dbo.sysjobs WHERE name = @job_name)\nBEGIN\n    EXEC msdb.dbo.sp_delete_job @job_name = @job_name;\nEND\nGO