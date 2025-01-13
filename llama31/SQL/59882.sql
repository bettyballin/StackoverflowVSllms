DELIMITER //\nCREATE PROCEDURE generate_numbers(IN max_nr INT)\nBEGIN\n  DECLARE i INT DEFAULT 1;\n  CREATE TEMPORARY TABLE numbers (nr INT);\n  WHILE i <= max_nr DO\n    INSERT INTO numbers VALUES (i);\n    SET i = i + 1;\n  END WHILE;\n  SELECT * FROM numbers;\nEND//\nDELIMITER ;