EXEC sp_trace_create @traceid OUTPUT, 2, N'C:\Temp\ProfilerTrace'\n   EXEC sp_trace_setevent @traceid, 10, 1, @on\n   EXEC sp_trace_setevent @traceid, 10, 12, @on\n   EXEC sp_trace_setstatus @traceid, 1