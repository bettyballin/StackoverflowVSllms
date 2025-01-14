DELIMITER //\n\nCREATE PROCEDURE update_tbl2()\nBEGIN\n    DECLARE done INT DEFAULT FALSE;\n    DECLARE current_id INT;\n    DECLARE current_name VARCHAR(255);\n    DECLARE @var INT DEFAULT 0;\n\n    -- Declare the cursor and handler\n    DECLARE cur CURSOR FOR SELECT id, name FROM tbl WHERE ...;\n    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;\n\n    -- Open the cursor\n    OPEN cur;\n\n    read_loop: LOOP\n        FETCH cur INTO current_id, current_name;\n        IF done THEN\n            LEAVE read_loop;\n        END IF;\n\n        -- Increment variable\n        SET @var := @var + 1;\n\n        -- Update tbl2 based on the logic\n        UPDATE tbl2 SET currname = current_name, col1 = @var WHERE tbl2.id = current_id;\n    END LOOP;\n\n    -- Close the cursor\n    CLOSE cur;\nEND //\n\nDELIMITER ;\n\n-- Call the procedure to execute it\nCALL update_tbl2();