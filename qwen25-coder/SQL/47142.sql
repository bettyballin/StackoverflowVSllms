SELECT CONCAT(\n    'INSERT INTO `table_name` (`field1`, `field2`) VALUES (',\n    QUOTE(field1), ', ',\n    QUOTE(field2),\n    ');'\n) AS insert_statement\nFROM table_name;