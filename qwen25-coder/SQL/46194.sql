DELIMITER //\n\nCREATE PROCEDURE InsertData()\nBEGIN\n    DECLARE var_name INT;\n\n    SELECT id INTO var_name \n    FROM table1 \n    WHERE some_column='something' \n    LIMIT 1;\n\n    INSERT INTO table2 (`number`) VALUES (var_name);\nEND //\n\nDELIMITER ;