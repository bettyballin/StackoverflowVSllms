CREATE FUNCTION NVL (first DATETIME, second DATETIME)\nRETURNS DATETIME\nBEGIN\n  RETURN IFNULL(first, second);\nEND