SELECT * FROM sys.dm_exec_query_stats\nWHERE query_hash = (SELECT query_hash FROM sys.dm_exec_query_stats WHERE query_text LIKE '%myProc%');