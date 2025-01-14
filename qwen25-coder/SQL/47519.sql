CREATE OR REPLACE PROCEDURE GetFilteredData(\n    in_status_id IN NUMBER DEFAULT NULL,\n    in_date IN DATE DEFAULT NULL,\n    in_other_parameter IN VARCHAR2 DEFAULT NULL\n) IS\n    query VARCHAR2(1000);\nBEGIN\n    query := 'SELECT * FROM table WHERE 1=1';\n    \n    IF in_status_id IS NOT NULL THEN\n        query := query || ' AND status_id = :a_status_id';\n    END IF;\n\n    IF in_date IS NOT NULL THEN\n        query := query || ' AND date = :a_date';\n    END IF;\n\n    IF in_other_parameter IS NOT NULL THEN\n        query := query || ' AND other_parameter = :a_other_param';\n    END IF;\n    \n    EXECUTE IMMEDIATE query USING \n        CASE WHEN in_status_id IS NOT NULL THEN in_status_id ELSE SYS.ODCIVARCHAR2LIST().EXTEND(0) END,\n        CASE WHEN in_date IS NOT NULL THEN in_date ELSE SYSDATE + 1 END,\n        CASE WHEN in_other_parameter IS NOT NULL THEN in_other_parameter ELSE SYS.ODCIVARCHAR2LIST().EXTEND(0) END;\nEXCEPTION\n    WHEN OTHERS THEN\n        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);\nEND GetFilteredData;\n/