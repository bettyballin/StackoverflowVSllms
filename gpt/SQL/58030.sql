SELECT \n    p.name AS sp_name,\n    LEN(m.definition) - LEN(REPLACE(m.definition, CHAR(10), '')) + 1 AS lines_of_code\nFROM \n    sys.procedures AS p\nJOIN \n    sys.sql_modules AS m\n    ON p.object_id = m.object_id\nORDER BY \n    sp_name;