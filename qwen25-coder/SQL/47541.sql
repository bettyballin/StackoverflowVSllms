CREATE OR REPLACE FUNCTION log_delete_audit() RETURNS TRIGGER AS $$\n   BEGIN\n       INSERT INTO audit_log (table_name, operation, user_id)\n       VALUES (\n           TG_TABLE_NAME,\n           'DELETE',\n           coalesce(current_setting('application_user', true), 'unknown')\n       );\n       RETURN OLD;\n   END;\n   $$ LANGUAGE plpgsql;\n\n   CREATE TRIGGER delete_audit_trigger\n   AFTER DELETE ON your_table\n   FOR EACH ROW EXECUTE FUNCTION log_delete_audit();