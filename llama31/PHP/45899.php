$pid = pg_backend_pid();\nexec("cpulimit -p $pid -l 50"); // limit to 50% CPU usage