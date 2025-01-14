DELIMITER $$\nCREATE TRIGGER after_activity_insert \nAFTER INSERT ON activities\nFOR EACH ROW\nBEGIN\n    UPDATE users SET score = score + NEW.points WHERE user_id = NEW.user_id;\nEND$$\nDELIMITER ;