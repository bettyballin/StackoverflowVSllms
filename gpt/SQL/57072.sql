CREATE OR REPLACE PROCEDURE export_to_xml(p_query IN VARCHAR2) IS\n    l_cursor    INTEGER;\n    l_col_cnt   INTEGER;\n    l_desc_tab  DBMS_SQL.DESC_TAB;\n    l_col_type  NUMBER;\n    l_col_name  VARCHAR2(200);\n    l_rowid     ROWID;\n    l_varchar2  VARCHAR2(4000);\n    l_number    NUMBER;\n    l_date      DATE;\n    \n    xml_output  CLOB := '';\n\n    PROCEDURE append_to_clob(p_text IN VARCHAR2) IS\n    BEGIN\n        xml_output := xml_output || p_text;\n    END append_to_clob;\n\nBEGIN\n    -- Open the cursor\n    l_cursor := DBMS_SQL.OPEN_CURSOR;\n    DBMS_SQL.PARSE(l_cursor, p_query, DBMS_SQL.NATIVE);\n    \n    -- Describe the columns\n    DBMS_SQL.DESCRIBE_COLUMNS(l_cursor, l_col_cnt, l_desc_tab);\n\n    -- Define columns based on their data types\n    FOR i IN 1..l_col_cnt LOOP\n        l_col_type := l_desc_tab(i).col_type;\n        \n        IF l_col_type = DBMS_SQL.VARCHAR2 OR l_col_type = DBMS_SQL.CHAR THEN\n            DBMS_SQL.DEFINE_COLUMN(l_cursor, i, l_varchar2, 4000);\n        ELSIF l_col_type = DBMS_SQL.NUMBER THEN\n            DBMS_SQL.DEFINE_COLUMN(l_cursor, i, l_number);\n        ELSIF l_col_type = DBMS_SQL.DATE THEN\n            DBMS_SQL.DEFINE_COLUMN(l_cursor, i, l_date);\n        ELSE\n            -- Handle other data types as needed\n            DBMS_SQL.DEFINE_COLUMN(l_cursor, i, l_varchar2, 4000);\n        END IF;\n    END LOOP;\n    \n    -- Execute the query\n    l_rowid := DBMS_SQL.EXECUTE(l_cursor);\n    \n    -- Fetch the rows\n    LOOP\n        EXIT WHEN DBMS_SQL.FETCH_ROWS(l_cursor) = 0;\n        \n        append_to_clob('<row>');\n        \n        FOR i IN 1..l_col_cnt LOOP\n            l_col_type := l_desc_tab(i).col_type;\n            l_col_name := l_desc_tab(i).col_name;\n            \n            IF l_col_type = DBMS_SQL.VARCHAR2 OR l_col_type = DBMS_SQL.CHAR THEN\n                DBMS_SQL.COLUMN_VALUE(l_cursor, i, l_varchar2);\n                append_to_clob('<' || l_col_name || '>' || l_varchar2 || '</' || l_col_name || '>');\n            ELSIF l_col_type = DBMS_SQL.NUMBER THEN\n                DBMS_SQL.COLUMN_VALUE(l_cursor, i, l_number);\n                append_to_clob('<' || l_col_name || '>' || l_number || '</' || l_col_name || '>');\n            ELSIF l_col_type = DBMS_SQL.DATE THEN\n                DBMS_SQL.COLUMN_VALUE(l_cursor, i, l_date);\n                append_to_clob('<' || l_col_name || '>' || TO_CHAR(l_date, 'YYYY-MM-DD"T"HH24:MI:SS') || '</' || l_col_name || '>');\n            ELSE\n                -- Handle other data types as needed\n                DBMS_SQL.COLUMN_VALUE(l_cursor, i, l_varchar2);\n                append_to_clob('<' || l_col_name || '>' || l_varchar2 || '</' || l_col_name || '>');\n            END IF;\n        END LOOP;\n        \n        append_to_clob('</row>');\n    END LOOP;\n    \n    -- Close the cursor\n    DBMS_SQL.CLOSE_CURSOR(l_cursor);\n    \n    -- Output the XML\n    DBMS_OUTPUT.PUT_LINE(xml_output);\n\nEXCEPTION\n    WHEN OTHERS THEN\n        IF DBMS_SQL.IS_OPEN(l_cursor) THEN\n            DBMS_SQL.CLOSE_CURSOR(l_cursor);\n        END IF;\n        RAISE;\nEND export_to_xml;\n/