CREATE TABLE procedure_logs (\n       log_id NUMBER GENERATED BY DEFAULT AS IDENTITY,\n       proc_name VARCHAR2(50),\n       param_values CLOB,\n       log_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n   );