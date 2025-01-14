-- Create a SQL tuning set\nBEGIN\n  DBMS_SQLTUNE.CREATE_TUNING_TASK(\n    sql_id        => 'your_sql_id_here',\n    scope         => DBMS_SQLTUNE.scope_comprehensive,\n    time_limit    => 60, -- in seconds\n    task_name     => 'my_tuning_task',\n    description   => 'Task to tune a query');\nEND;\n/\n\n-- Execute the tuning task\nBEGIN\n  DBMS_SQLTUNE.EXECUTE_TUNING_TASK(task_name => 'my_tuning_task');\nEND;\n/\n\n-- Report the findings\nSET LONG 2000000\nSET LINESIZE 160\nSELECT DBMS_SQLTUNE.REPORT_TUNING_TASK('my_tuning_task') FROM DUAL;