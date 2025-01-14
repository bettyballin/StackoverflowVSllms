CREATE TRIGGER check_employee_employer\nBEFORE INSERT OR UPDATE ON Employee\nFOR EACH ROW\nBEGIN\n    IF NEW.agency_id IS NOT NULL AND NEW.publisher_id IS NOT NULL THEN\n        SIGNAL SQLSTATE '45000' \n        SET MESSAGE_TEXT = 'An employee cannot be associated with both an agency and a publisher.';\n    END IF;\nEND;