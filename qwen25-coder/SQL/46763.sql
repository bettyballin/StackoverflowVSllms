CREATE TRIGGER check_fd_before_insert\nBEFORE INSERT ON your_table\nFOR EACH ROW\nBEGIN\n  -- Check if new row violates FD (simplified example)\n  IF EXISTS(SELECT * FROM your_table WHERE columnA = NEW.columnA AND columnB != NEW.columnB) THEN\n    SIGNAL SQLSTATE '45000'\n      SET MESSAGE_TEXT = 'Violation of functional dependency';\n  END IF;\nEND;