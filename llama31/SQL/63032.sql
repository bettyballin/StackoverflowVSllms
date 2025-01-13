CREATE PROCEDURE sp_ArchiveRecords\nAS\nBEGIN\n    DECLARE @RetentionPeriod INT = 30;  -- adjust to your needs\n\n    DELETE FROM ArchivedRecords\n    WHERE DateArchived < DATEADD(DAY, -@RetentionPeriod, GETDATE());\nEND;\nGO\n\n-- Schedule the job\nEXEC sp_add_jobschedule @job_id=N'ArchiveRecords', @name=N'Daily Archive', \n        @freq_type=4,  -- daily\n        @freq_interval=1, \n        @freq_recurrence_factor=1, \n        @active_start_time=000000, \n        @active_end_time=235959;\nGO