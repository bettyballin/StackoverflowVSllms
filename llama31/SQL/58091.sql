DELIMITER //\n\nCREATE PROCEDURE your_procedure(IN param_ids VARCHAR(255))\nBEGIN\n  SET @sql = CONCAT('SELECT * FROM your_table WHERE id IN (', param_ids, ')');\n  PREPARE stmt FROM @sql;\n  EXECUTE stmt;\n  DEALLOCATE PREPARE stmt;\nEND //\n\nDELIMITER ;