SELECT object_name, last_ddl_time\nFROM user_objects\nWHERE object_type = 'PROCEDURE'\nAND object_name = 'YOUR_PROCEDURE_NAME';