DELIMITER //\n\nCREATE PROCEDURE InsertIfTableExists()\nBEGIN\n    DECLARE table_exists INT DEFAULT 0;\n    \n    SELECT COUNT(*)\n    INTO table_exists\n    FROM information_schema.TABLES\n    WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'country';\n    \n    IF table_exists > 0 THEN\n        INSERT INTO country (name) VALUES ('Afghanistan'), ('Aland Islands');\n    END IF;\nEND //\n\nDELIMITER ;\n\nCALL InsertIfTableExists();