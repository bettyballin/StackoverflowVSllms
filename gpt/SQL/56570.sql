DELIMITER //\n\nCREATE TRIGGER after_user_insert\nAFTER INSERT ON central_db.users\nFOR EACH ROW\nBEGIN\n    INSERT INTO forum_db.users (id, username, email, password, created_at)\n    VALUES (NEW.id, NEW.username, NEW.email, NEW.password, NEW.created_at);\n\n    INSERT INTO news_db.users (id, username, email, password, created_at)\n    VALUES (NEW.id, NEW.username, NEW.email, NEW.password, NEW.created_at);\n\n    INSERT INTO calendar_db.users (id, username, email, password, created_at)\n    VALUES (NEW.id, NEW.username, NEW.email, NEW.password, NEW.created_at);\nEND//\n\nDELIMITER ;