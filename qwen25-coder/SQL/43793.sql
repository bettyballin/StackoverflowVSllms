-- Check memory usage\nSELECT \n    (Physical_memory_in_use_kb/1024) AS Memory_usage_mb,\n    connection_id, client_program_name\nFROM sys.dm_exec_connections;\n\n-- Check database size\nEXEC sp_MSforeachdb 'USE [?]; EXEC sp_spaceused';