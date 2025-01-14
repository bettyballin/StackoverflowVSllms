CREATE TRIGGER before_insert_actors\nBEFORE INSERT ON actors\nFOR EACH ROW\nBEGIN\n  SET NEW.stage_name = CONCAT(NEW.forename, ' ', NEW.surname);\nEND;