USE msdb;\nGO\n\nEXEC sp_update_job \n    @job_name = 'YourJobName', \n    @allow_lose_sync_to_job_server = 1,\n    @disallow_concurrent_execution = 1;\n\nGO