SELECT name, system_type_id, user_type_id, schema_id, principal_id, is_user_defined\nFROM sys.types\nWHERE is_user_defined = 1;