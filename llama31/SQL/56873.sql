SELECT DBMS_METADATA.get_ddl('PROCEDURE', procedure_name) \nFROM user_objects \nWHERE object_type = 'PROCEDURE';