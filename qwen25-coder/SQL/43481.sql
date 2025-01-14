CREATE TABLE log_table (\n    log_id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,\n    log_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n    message VARCHAR2(4000)\n);