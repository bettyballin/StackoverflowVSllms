ALTER SESSION SET sql_trace = TRUE;\n  -- Run your query here\n  ALTER SESSION SET sql_trace = FALSE;\n\n  -- Use TKPROF to format the trace file\n  tkprof trace_file.trc output_file.txt