DECLARE\n    is_nullable VARCHAR2(1);\nBEGIN\n    -- Check if the column is nullable\n    SELECT NULLABLE INTO is_nullable\n    FROM USER_TAB_COLUMNS\n    WHERE TABLE_NAME = 'MYTABLE'\n      AND COLUMN_NAME = 'MYCOLUMN';\n\n    -- If the column is not nullable, modify it to allow nulls\n    IF is_nullable = 'N' THEN\n        EXECUTE IMMEDIATE 'ALTER TABLE MYTABLE MODIFY MYCOLUMN NULL';\n    ELSE\n        DBMS_OUTPUT.PUT_LINE('Column is already nullable');\n    END IF;\nEXCEPTION\n    WHEN NO_DATA_FOUND THEN\n        DBMS_OUTPUT.PUT_LINE('Table or column does not exist.');\nEND;