DELIMITER //\n\nCREATE FUNCTION NVL (first DATETIME, second DATETIME)\nRETURNS DATETIME\nDETERMINISTIC\nBEGIN\n    RETURN IFNULL(first, second);\nEND //\n\nDELIMITER ;