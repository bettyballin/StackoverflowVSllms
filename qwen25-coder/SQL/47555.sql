DECLARE\n  l_table_name VARCHAR2(100) := 'A';\n  l_primary_key_value NUMBER := 1;\n  CURSOR cur_tables IS \n    SELECT table_name, constraint_column_usage.column_name AS primary_key_column,\n           referenced_table_name, referenced_constraint_column_usage.column_name AS foreign_key_column\n    FROM information_schema.table_constraints tc\n      JOIN information_schema.constraint_column_usage ON tc.constraint_name = constraint_column_usage.constraint_name\n      JOIN (\n        SELECT table_name, column_name\n        FROM information_schema.constraint_column_usage\n        WHERE constraint_name IN (\n          SELECT UNIQUE constraint_name \n          FROM information_schema.key_column_usage kcu\n          WHERE table_name = l_table_name AND column_name IN (\n            SELECT COLUMN_NAME \n            FROM information_schema.table_constraints tc2\n            JOIN information_schema.constraint_column_usage ON tc2.constraint_name = constraint_column_usage.constraint_name\n            WHERE constraint_type = 'PRIMARY KEY' AND tc2.table_name = l_table_name\n          )\n        ) AND table_name != l_table_name\n      ) referenced_constraint_column_usage \n    ON tc.constraint_type='FOREIGN KEY'\n    WHERE tc.constraint_schema=USER;\n\n  TYPE t_ref IS RECORD (\n    primary_key_value NUMBER,\n    insert_statement VARCHAR2(2000)\n  );\n\n  FUNCTION generate_insert_for_record(p_table_name IN VARCHAR2, p_primary_key_value IN NUMBER) RETURN t_ref AS\n    l_stmt VARCHAR2(2000);\n    l_values VARCHAR2(1000);\n    CURSOR cur_columns IS\n      SELECT COLUMN_NAME FROM all_tab_columns WHERE table_name = UPPER(p_table_name);\n  BEGIN\n    FOR c IN cur_columns LOOP\n      EXECUTE IMMEDIATE 'SELECT "' || c.COLUMN_NAME || '" FROM "' || p_table_name || '" WHERE ROWID = (SELECT MIN(ROWID) FROM "' || p_table_name || '" WHERE "' || l_primary_key_column || '" = :1)' INTO l_values USING p_primary_key_value;\n      IF l_values IS NOT NULL THEN\n        l_stmt := l_stmt || '''' || REPLACE(l_values, '''', '''''') || ''', ';\n      ELSE\n        l_stmt := l_stmt || 'NULL, ';\n      END IF;\n    END LOOP;\n    l_stmt := RTRIM(l_stmt, ', ') || ');';\n    RETURN (p_primary_key_value, 'INSERT INTO "' || p_table_name || '"( ALL_COLUMN_NAMES ) VALUES (' || SUBSTR(l_stmt, INSTR(l_stmt, '(') + 1));\n  END generate_insert_for_record;\n\n  FUNCTION get_all_columns(p_table_name VARCHAR2) RETURN VARCHAR2 AS\n    l_cols VARCHAR2(4000);\n  BEGIN\n    FOR c IN (SELECT COLUMN_NAME FROM all_tab_columns WHERE table_name = UPPER(p_table_name)) LOOP\n      l_cols := l_cols || '"' || c.COLUMN_NAME || '", ';\n    END LOOP;\n    RETURN RTRIM(l_cols, ', ');\n  END get_all_columns;\n\n  TYPE t_ref_list IS TABLE OF t_ref INDEX BY NUMBER;\n  l_ref_list t_ref_list;\nBEGIN\n  OPEN cur_tables;\n  LOOP\n    FETCH cur_tables INTO l_table_name, l_primary_key_column, referenced_constraint_column_usage.referenced_table_name, referenced_constraint_column_usage.foreign_key_column;\n    EXIT WHEN cur_tables%NOTFOUND;\n\n    FOR r IN (SELECT DISTINCT foreign_key_value FROM (\n      SELECT a.primary_key_value AS foreign_key_value\n      FROM (SELECT 'a' AS table_name, a_id AS primary_key_value FROM A WHERE a_id = l_primary_key_value) a\n      LEFT JOIN B b ON a.a_id = b.a_id\n    )) LOOP\n      INSERT INTO temp_insert_statements (table_name, insert_statement)\n      VALUES (\n        referenced_constraint_column_usage.referenced_table_name,\n        replace(generate_insert_for_record(referenced_constraint_column_usage.referenced_table_name, r.foreign_key_value).insert_statement, 'ALL_COLUMN_NAMES', get_all_columns(referenced_constraint_column_usage.referenced_table_name))\n      );\n    END LOOP;\n  END LOOP;\n\n  -- Add the master table's insert statement\n  INSERT INTO temp_insert_statements (table_name, insert_statement)\n  VALUES (\n    l_table_name,\n    replace(generate_insert_for_record(l_table_name, l_primary_key_value).insert_statement, 'ALL_COLUMN_NAMES', get_all_columns(l_table_name))\n  );\n\n  CLOSE cur_tables;\n\n  -- Commit if needed, and then output or export the insert statements\n  FOR rec IN (SELECT insert_statement FROM temp_insert_statements ORDER BY table_name) LOOP\n    DBMS_OUTPUT.PUT_LINE(rec.insert_statement);\n  END LOOP;\nEND;\n/