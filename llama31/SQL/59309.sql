CREATE TRIGGER after_delete_tree\nAFTER DELETE ON tree\nFOR EACH ROW\nBEGIN\n  INSERT INTO update_queue (num)\n  SELECT orig FROM tree WHERE term = OLD.term;\nEND;