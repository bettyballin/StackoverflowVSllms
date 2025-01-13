SELECT \n    CASE \n        WHEN column_name < 1 THEN CEILING(column_name)\n        ELSE column_name\n    END as rounded_value\nFROM \n    your_table_name;