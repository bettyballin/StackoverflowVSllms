DELIMITER $$\nCREATE TRIGGER trg_after_insert\nAFTER INSERT ON your_table\nFOR EACH ROW\nBEGIN\n    SELECT NEW.id INTO @inserted_id;\nEND$$\nDELIMITER ;