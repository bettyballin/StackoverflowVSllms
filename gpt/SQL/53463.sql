USE msdb;\n   GO\n   EXEC sp_update_job \n       @job_name = 'YourJobName', \n       @owner_login_name = 'YourSQLLogin';\n   GO