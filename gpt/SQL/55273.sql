CREATE TRIGGER assign_child_id_trigger\nBEFORE INSERT ON CHILD\nFOR EACH ROW\nEXECUTE FUNCTION assign_child_id();