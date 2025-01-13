DELIMITER //\n\nCREATE TRIGGER after_user_delete\nAFTER DELETE ON central_db.users\nFOR EACH ROW\nBEGIN\n    DELETE FROM forum_db.users WHERE id = OLD.id;\n    DELETE FROM news_db.users WHERE id = OLD.id;\n    DELETE FROM calendar_db.users WHERE id = OLD.id;\nEND//\n\nDELIMITER ;