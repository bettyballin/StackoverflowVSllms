DECLARE\n    v_id VARCHAR2(50) := 'your_id_here';\n    CURSOR_TYPE IS SYS_REFCURSOR;\n    result_cursor CURSOR_TYPE;\n    info VARCHAR2(100);\n    data VARCHAR2(100);\nBEGIN\n    fetch_data_by_id(v_id, result_cursor);\n\n    LOOP\n        FETCH result_cursor INTO info, data;\n        EXIT WHEN result_cursor%NOTFOUND;\n\n        -- Process each row here\n        DBMS_OUTPUT.PUT_LINE('Info: ' || info || ', Data: ' || data);\n    END LOOP;\n\n    CLOSE result_cursor;\nEND;\n/