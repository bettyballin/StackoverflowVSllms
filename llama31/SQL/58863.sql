INSERT INTO table_name (column1, column2)\nVALUES ('value1', 'value2')\nON DUPLICATE KEY UPDATE column2 = VALUES(column2);