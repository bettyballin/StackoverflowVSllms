SELECT total_worker_time/execution_count AS AvgCPU  \n, total_worker_time AS TotalCPU\n, total_elapsed_time/execution_count AS AvgDuration  \n, total_elapsed_time AS TotalDuration  \n, (total_logical_reads+total_physical_reads)/execution_count AS AvgReads \n, (total_logical_reads+total_physical_reads) AS TotalReads\n, execution_count   \n, SUBSTRING(st.TEXT, (qs.statement_start_offset/2)+1  \n, ((CASE qs.statement_end_offset  WHEN -1 THEN datalength(st.TEXT)  \nELSE qs.statement_end_offset  \nEND - qs.statement_start_offset)/2) + 1) AS txt  \n, query_plan\nFROM sys.dm_exec_query_stats AS qs  \ncross apply sys.dm_exec_sql_text(qs.sql_handle) AS st  \ncross apply sys.dm_exec_query_plan (qs.plan_handle) AS qp \nORDER BY 1 DESC