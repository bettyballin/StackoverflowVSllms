DECLARE\n    v_owner VARCHAR2(128) := 'SCHEMA_USER';\n    v_tablename VARCHAR2(128) := 'TABLENAME';\n    l_cursor INTEGER;\n    l_desc   SYS.ODCIVARCHAR2LIST; -- List of column names\n    l_cols   DBMS_SQL.DESC_TAB2;\n    l_col_cnt NUMBER;\n\nBEGIN\n    l_cursor := DBMS_SQL.OPEN_CURSOR;\n    DBMS_SQL.PARSE(l_cursor, 'SELECT * FROM ' || v_owner || '.' || v_tablename, DBMS_SQL.NATIVE);\n    DBMS_SQL.DESCRIBE_COLUMNS2(l_cursor, l_col_cnt, l_cols);\n\n    FOR i IN 1..l_col_cnt LOOP\n        -- Process each column dynamically\n        -- For example, you could store column names in a list or process data types.\n        l_desc.EXTEND;\n        l_desc(i) := l_cols(i).col_name;\n    END LOOP;\n\n    DBMS_SQL.CLOSE_CURSOR(l_cursor);\n\n    -- Now you can use l_desc to understand the structure of your table dynamically.\n\n    -- Note: To fully populate a collection of rowtype dynamically, \n    --       you would need to create an anonymous PL/SQL block using EXECUTE IMMEDIATE\n    --       and handle each row column by column.\nEND;