WITH OrderedUsers AS (\n    SELECT userid, ROW_NUMBER() OVER (ORDER BY column_name) AS row_num\n    FROM users\n)\nSELECT row_num\nFROM OrderedUsers\nWHERE userid = '123';