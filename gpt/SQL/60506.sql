DELIMITER //\n\nCREATE TRIGGER before_items_update\nBEFORE UPDATE ON items\nFOR EACH ROW\nBEGIN\n    IF NEW.tot <> OLD.tot THEN\n        INSERT IGNORE INTO update_queue (num) VALUES ((SELECT orig FROM tree WHERE term = OLD.num));\n    END IF;\nEND //\n\nDELIMITER ;