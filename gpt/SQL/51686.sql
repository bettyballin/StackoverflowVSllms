GRANT SELECT ON dbo.sysjobs TO [JobCreator];\nGRANT SELECT ON dbo.sysschedules TO [JobCreator];\nGRANT EXECUTE ON sp_add_job TO [JobCreator];\nGRANT EXECUTE ON sp_update_job TO [JobCreator];\nGRANT EXECUTE ON sp_delete_job TO [JobCreator];\nGRANT EXECUTE ON sp_add_jobstep TO [JobCreator];\nGRANT EXECUTE ON sp_update_jobstep TO [JobCreator];\nGRANT EXECUTE ON sp_delete_jobstep TO [JobCreator];\nGRANT EXECUTE ON sp_add_jobserver TO [JobCreator];\nGRANT EXECUTE ON sp_update_jobserver TO [JobCreator];\nGRANT EXECUTE ON sp_delete_jobserver TO [JobCreator];\n-- Deny permission to create schedules\nDENY EXECUTE ON sp_add_schedule TO [JobCreator];\nDENY EXECUTE ON sp_update_schedule TO [JobCreator];\nDENY EXECUTE ON sp_delete_schedule TO [JobCreator];\nGO