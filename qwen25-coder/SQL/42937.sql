DELIMITER //\n\nCREATE TRIGGER example_trigger \nBEFORE UPDATE ON your_table_name\nFOR EACH ROW\nBEGIN\n    IF NEW.fire_trigger = TRUE THEN\n        -- Your trigger logic here\n        SIGNAL SQLSTATE '45000'\n        SET MESSAGE_TEXT = 'User-initiated update detected and processed by trigger.';\n        \n        -- Reset the flag to avoid unnecessary firing on subsequent operations\n        SET NEW.fire_trigger = FALSE;\n    END IF;\nEND//\n\nDELIMITER ;