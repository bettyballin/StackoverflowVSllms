SELECT *\nFROM ::fn_trace_gettable(CONVERT(varchar(150), (SELECT TOP 1 value FROM sys.fn_xe_file_target_read_file('PathToYourTrace.trc', NULL, NULL, NULL))), DEFAULT)\nWHERE EventClass = 46 -- RPC:Completed\n   OR EventClass = 35; -- SP:StmtCompleted