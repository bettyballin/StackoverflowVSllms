DELIMITER //\nCREATE PROCEDURE insert_download(filename VARCHAR(255), date DATE)\nBEGIN\n    IF (SELECT COUNT(*) FROM downloads) >= 10 THEN\n        DELETE FROM downloads ORDER BY date ASC LIMIT 1;\n    END IF;\n    INSERT INTO downloads (filename, date) VALUES (filename, date);\nEND;//\nDELIMITER ;