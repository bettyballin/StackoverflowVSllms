WITH OrderedTable AS (\n    SELECT id, name, ROW_NUMBER() OVER (ORDER BY name) as row_num\n    FROM table\n)\nSELECT row_num\nFROM OrderedTable\nWHERE id = 47;