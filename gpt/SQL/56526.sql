SELECT grantee, table_catalog, table_schema, table_name, privilege_type\n    FROM information_schema.role_table_grants\n    WHERE table_name = 'uvusers' AND grantee = 'your_user';