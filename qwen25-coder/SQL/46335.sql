DELIMITER //\n  CREATE PROCEDURE add_numbers(IN a INT, IN b INT, OUT result INT)\n  BEGIN\n      SET result = a + b;\n  END//\n  DELIMITER ;