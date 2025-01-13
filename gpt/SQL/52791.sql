CREATE OR REPLACE FUNCTION check_lock_status() RETURNS TRIGGER AS $$\nBEGIN\n    IF NEW.lock_status IS DISTINCT FROM OLD.lock_status THEN\n        RAISE EXCEPTION 'You cannot modify the lock_status directly';\n    END IF;\n    IF OLD.lock_status IS NOT NULL AND OLD.lock_status <> 0 THEN\n        RAISE EXCEPTION 'This record is locked and cannot be updated';\n    END IF;\n    RETURN NEW;\nEND;\n$$ LANGUAGE plpgsql;