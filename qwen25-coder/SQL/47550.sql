CREATE OR REPLACE FUNCTION get_digits(p_string IN VARCHAR2) RETURN VARCHAR2 IS\n    v_result VARCHAR2(4000);\nBEGIN\n    FOR i IN 1 .. LENGTH(p_string) LOOP\n        IF SUBSTR(p_string, i, 1) BETWEEN '0' AND '9' THEN\n            v_result := v_result || SUBSTR(p_string, i, 1);\n        END IF;\n    END LOOP;\n    RETURN v_result;\nEND get_digits;\n/