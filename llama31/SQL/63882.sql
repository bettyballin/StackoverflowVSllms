CREATE OR REPLACE PROCEDURE sp_SearchData(\n    p_status_id IN NUMBER,\n    p_date IN DATE,\n    p_other_parameter IN VARCHAR2\n)\nAS\n    v_sql VARCHAR2(4000) := 'SELECT * FROM table WHERE 1=1';\nBEGIN\n    IF p_status_id IS NOT NULL THEN\n        v_sql := v_sql || ' AND status_id = ' || p_status_id;\n    END IF;\n\n    IF p_date IS NOT NULL THEN\n        v_sql := v_sql || ' AND date = ' || TO_CHAR(p_date, 'YYYY-MM-DD');\n    END IF;\n\n    IF p_other_parameter IS NOT NULL THEN\n        v_sql := v_sql || ' AND other_parameter = ' || p_other_parameter;\n    END IF;\n\n    EXECUTE IMMEDIATE v_sql;\nEND;