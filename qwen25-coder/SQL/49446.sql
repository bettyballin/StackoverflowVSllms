SELECT * FROM sys.trigger_events;\n   SELECT definition \n   FROM sys.sql_modules\n   WHERE object_id IN (SELECT object_id FROM sys.triggers WHERE parent_id = OBJECT_ID('tablename'));