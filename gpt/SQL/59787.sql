CREATE TRIGGER trigger_validate_path\nBEFORE INSERT OR UPDATE ON tree\nFOR EACH ROW\nEXECUTE FUNCTION validate_path();