SET GLOBAL slow_query_log = 'ON';\n   SET GLOBAL slow_query_log_file = '/var/log/mysql/slow.log';\n   SET GLOBAL long_query_time = 1; -- Adjust the time threshold as needed