CREATE TRIGGER trg_external_status_check\nBEFORE INSERT OR UPDATE ON external_status\nFOR EACH ROW\nBEGIN\n  IF NEW.system_id = 2 AND NOT EXISTS (\n    SELECT 1 FROM external_status\n    WHERE prospect_id = NEW.prospect_id AND system_id = 1 AND status_id = 1\n  ) THEN\n    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot set ext_status_2_id unless ext_status_1_id is 1';\n  END IF;\nEND;