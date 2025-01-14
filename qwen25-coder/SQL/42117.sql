DELIMITER //\n\nCREATE PROCEDURE GetAllData()\nBEGIN\n    DECLARE done INT DEFAULT FALSE;\n    DECLARE table_name VARCHAR(255);\n    DECLARE cur CURSOR FOR SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA = 'your_database_name' AND TABLE_NAME LIKE 'customer_%';\n    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;\n\n    DROP TEMPORARY TABLE IF EXISTS temp_all_data;\n    CREATE TEMPORARY TABLE temp_all_data LIKE customer_1; -- Assuming customer_1 schema is same for all\n\n    OPEN cur;\n\n    read_loop: LOOP\n        FETCH cur INTO table_name;\n        IF done THEN\n            LEAVE read_loop;\n        END IF;\n        SET @query = CONCAT('INSERT INTO temp_all_data SELECT * FROM ', table_name);\n        PREPARE stmt FROM @query;\n        EXECUTE stmt;\n        DEALLOCATE PREPARE stmt;\n    END LOOP;\n\n    CLOSE cur;\n\n    SELECT * FROM temp_all_data;\n\n    DROP TEMPORARY TABLE temp_all_data;\nEND //\n\nDELIMITER ;