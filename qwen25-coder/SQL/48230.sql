CREATE TRIGGER employees_audit_trigger\nAFTER INSERT OR UPDATE OR DELETE ON employees\nFOR EACH ROW EXECUTE FUNCTION audit_change();