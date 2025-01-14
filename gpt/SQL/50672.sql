DELIMITER //\n\nCREATE PROCEDURE ParseXML()\nBEGIN\n    DECLARE xmlDoc TEXT;\n    DECLARE xmlLen INT;\n    DECLARE i INT;\n    DECLARE tempNode VARCHAR(255);\n\n    SET xmlDoc = '<parent><child>Example 1</child><child>Example 2</child></parent>';\n    SET xmlLen = (LENGTH(xmlDoc) - LENGTH(REPLACE(xmlDoc, '<child>', ''))) / LENGTH('<child>');\n    \n    CREATE TEMPORARY TABLE IF NOT EXISTS tempTable (\n        nodeValue VARCHAR(255)\n    );\n\n    SET i = 1;\n    WHILE i <= xmlLen DO\n        SET tempNode = ExtractValue(xmlDoc, CONCAT('/parent/child[', i, ']'));\n        INSERT INTO tempTable (nodeValue) VALUES (tempNode);\n        SET i = i + 1;\n    END WHILE;\n\n    SELECT * FROM tempTable;\n\n    DROP TEMPORARY TABLE IF EXISTS tempTable;\nEND //\n\nDELIMITER ;