-- Check for locks\n   SELECT * \n   FROM sys.dm_tran_locks \n   WHERE request_session_id = @@SPID;