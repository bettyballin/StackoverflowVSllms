CREATE OR REPLACE FUNCTION check_existing_open_record()\nRETURNS TRIGGER AS $$\nBEGIN\n  IF EXISTS (SELECT 1 FROM bar WHERE id = NEW.id AND dropped IS NULL) THEN\n    RAISE EXCEPTION 'Cannot insert new record for ID % as there is an existing open record.', NEW.id;\n  END IF;\n  RETURN NEW;\nEND;\n$$ LANGUAGE plpgsql;\n\nCREATE TRIGGER prevent_insert_with_open_record\nBEFORE INSERT ON bar\nFOR EACH ROW EXECUTE FUNCTION check_existing_open_record();