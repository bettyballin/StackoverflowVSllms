SELECT TRANSACTION_ISOLATION_LEVEL = CASE transaction_isolation_level \n    WHEN 0 THEN 'Unspecified' \n    WHEN 1 THEN 'ReadUncommitted' -- NOLOCK\n    WHEN 2 THEN 'ReadCommitted'\n    WHEN 3 THEN 'RepeatableRead'\n    WHEN 4 THEN 'Serializable'\n    WHEN 5 THEN 'Snapshot'\nEND\nFROM sys.dm_exec_sessions\nWHERE session_id = @@SPID;