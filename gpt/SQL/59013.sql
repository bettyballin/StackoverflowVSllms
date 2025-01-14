DECLARE\n    CURSOR table_cursor IS\n        SELECT table_name\n        FROM user_tables;\n        \n    table_name user_tables.table_name%TYPE;\n    row_count NUMBER;\n    max_rows NUMBER := 0;\n    max_table user_tables.table_name%TYPE;\n    \nBEGIN\n    FOR table_rec IN table_cursor LOOP\n        EXECUTE IMMEDIATE 'SELECT COUNT(*) FROM ' || table_rec.table_name INTO row_count;\n        IF row_count > max_rows THEN\n            max_rows := row_count;\n            max_table := table_rec.table_name;\n        END IF;\n    END LOOP;\n    \n    DBMS_OUTPUT.PUT_LINE('Table with maximum rows: ' || max_table || ' with ' || max_rows || ' rows');\nEND;